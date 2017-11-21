package com.supermarket.yun.platform.slowloris.service.security.cache;

import com.google.common.collect.Sets;
import com.supermarket.yun.platform.slowloris.common.utils.ServletUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * 缓存
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:03
 */
public class SessionCacheManager implements CacheManager {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new SessionCache<K, V>(name);
    }

    /**
     * SESSION缓存管理类
     */
    public class SessionCache<K, V> implements Cache<K, V> {


        private String cacheKeyName = null;

        public SessionCache(String cacheKeyName) {
            this.cacheKeyName = cacheKeyName;
        }

        public Session getSession() {
            Session session = null;
            try {
                Subject subject = SecurityUtils.getSubject();
                session = subject.getSession(false);
                if (session == null) {
                    session = subject.getSession();
                }
            } catch(InvalidSessionException e) {
                LOGGER.error("Invalid session error", e);
            } catch(UnavailableSecurityManagerException e2) {
                LOGGER.error("Unavailable SecurityManager error", e2);
            }
            return session;
        }

        @SuppressWarnings("unchecked")
        @Override
        public V get(K key) throws CacheException {
            if (key == null) {
                return null;
            }

            V v = null;
            HttpServletRequest request = ServletUtils.getRequest();
            if (request != null) {
                v = (V) request.getAttribute(cacheKeyName);
                if (v != null) {
                    return v;
                }
            }

            V value = null;
            value = (V) getSession().getAttribute(cacheKeyName);
            LOGGER.debug("get {} {} {}", cacheKeyName, key, request != null ? request.getRequestURI() : "");

            if (request != null && value != null) {
                request.setAttribute(cacheKeyName, value);
            }
            return value;
        }

        @Override
        public V put(K key, V value) throws CacheException {
            if (key == null) {
                return null;
            }

            getSession().setAttribute(cacheKeyName, value);

            if (LOGGER.isDebugEnabled()) {
                HttpServletRequest request = ServletUtils.getRequest();
                LOGGER.debug("put {} {} {}", cacheKeyName, key, request != null ? request.getRequestURI() : "");
            }

            return value;
        }

        @SuppressWarnings("unchecked")
        @Override
        public V remove(K key) throws CacheException {

            V value = null;
            value = (V) getSession().removeAttribute(cacheKeyName);
            LOGGER.debug("remove {} {}", cacheKeyName, key);

            return value;
        }

        @Override
        public void clear() throws CacheException {
            getSession().removeAttribute(cacheKeyName);
            LOGGER.debug("clear {}", cacheKeyName);
        }

        @Override
        public int size() {
            LOGGER.debug("invoke session size abstract size method not supported.");
            return 0;
        }

        @Override
        public Set<K> keys() {
            LOGGER.debug("invoke session keys abstract size method not supported.");
            return Sets.newHashSet();
        }

        @Override
        public Collection<V> values() {
            LOGGER.debug("invoke session values abstract size method not supported.");
            return Collections.emptyList();
        }
    }
}
