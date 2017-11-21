package com.supermarket.yun.platform.slowloris.service.security.cache;

import com.google.common.collect.Sets;
import com.supermarket.yun.platform.slowloris.common.utils.ServletUtils;
import com.supermarket.yun.platform.slowloris.service.utils.JedisUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * 自定义授权缓存管理类
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:03
 */
public class JedisCacheManager implements CacheManager {

    private final static Logger LOGGER = LogManager.getLogger();

    private String cacheKeyPrefix = "dataact_cache_";

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new JedisCache<K, V>(cacheKeyPrefix + name);
    }

    public String getCacheKeyPrefix() {
        return cacheKeyPrefix;
    }

    public void setCacheKeyPrefix(String cacheKeyPrefix) {
        this.cacheKeyPrefix = cacheKeyPrefix;
    }

    /**
     * 自定义授权缓存管理类
     *
     * @author ThinkGem
     * @version 2014-7-20
     */
    public class JedisCache<K, V> implements Cache<K, V> {


        private String cacheKeyName = null;

        public JedisCache(String cacheKeyName) {
            this.cacheKeyName = cacheKeyName;
            // if (!JedisUtils.exists(cacheKeyName)){
            // Map<String, Object> map = Maps.newHashMap();
            // JedisUtils.setObjectMap(cacheKeyName, map, 60 * 60 * 24);
            // }
            // logger.debug("Init: cacheKeyName {} ", cacheKeyName);
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
            Jedis jedis = null;
            try {
                jedis = JedisUtils.getResource();
                value = (V) JedisUtils
                        .toObject(jedis.hget(JedisUtils.getBytesKey(cacheKeyName), JedisUtils.getBytesKey(key)));
                LOGGER.debug("get {} {} {}", cacheKeyName, key, request != null ? request.getRequestURI() : "");
            } catch(Exception e) {
                LOGGER.error("get {} {} {} {}", cacheKeyName, key, request != null ? request.getRequestURI() : "", e);
            } finally {
                JedisUtils.returnResource(jedis);
            }

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

            Jedis jedis = null;
            try {
                jedis = JedisUtils.getResource();
                jedis.hset(JedisUtils.getBytesKey(cacheKeyName), JedisUtils.getBytesKey(key),
                        JedisUtils.toBytes(value));
                LOGGER.debug("put {} {} = {}", cacheKeyName, key, value);
            } catch(Exception e) {
                LOGGER.error("put {} {} {}", cacheKeyName, key, e);
            } finally {
                JedisUtils.returnResource(jedis);
            }
            return value;
        }

        @SuppressWarnings("unchecked")
        @Override
        public V remove(K key) throws CacheException {
            V value = null;
            Jedis jedis = null;
            try {
                jedis = JedisUtils.getResource();
                value = (V) JedisUtils
                        .toObject(jedis.hget(JedisUtils.getBytesKey(cacheKeyName), JedisUtils.getBytesKey(key)));
                jedis.hdel(JedisUtils.getBytesKey(cacheKeyName), JedisUtils.getBytesKey(key));
                LOGGER.debug("remove {} {}", cacheKeyName, key);
            } catch(Exception e) {
                LOGGER.warn("remove {} {}", cacheKeyName, key, e);
            } finally {
                JedisUtils.returnResource(jedis);
            }
            return value;
        }

        @Override
        public void clear() throws CacheException {
            Jedis jedis = null;
            try {
                jedis = JedisUtils.getResource();
                jedis.hdel(JedisUtils.getBytesKey(cacheKeyName));
                LOGGER.debug("clear {}", cacheKeyName);
            } catch(Exception e) {
                LOGGER.error("clear {} {}", cacheKeyName, e);
            } finally {
                JedisUtils.returnResource(jedis);
            }
        }

        @Override
        public int size() {
            int size = 0;
            Jedis jedis = null;
            try {
                jedis = JedisUtils.getResource();
                size = jedis.hlen(JedisUtils.getBytesKey(cacheKeyName)).intValue();
                LOGGER.debug("size {} {} ", cacheKeyName, size);
                return size;
            } catch(Exception e) {
                LOGGER.error("clear {} {}", cacheKeyName, e);
            } finally {
                JedisUtils.returnResource(jedis);
            }
            return size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public Set<K> keys() {
            Set<K> keys = Sets.newHashSet();
            Jedis jedis = null;
            try {
                jedis = JedisUtils.getResource();
                Set<byte[]> set = jedis.hkeys(JedisUtils.getBytesKey(cacheKeyName));
                for(byte[] key : set) {
                    Object obj = (K) JedisUtils.getObjectKey(key);
                    if (obj != null) {
                        keys.add((K) obj);
                    }
                }
                LOGGER.debug("keys {} {} ", cacheKeyName, keys);
                return keys;
            } catch(Exception e) {
                LOGGER.error("keys {} {}", cacheKeyName, e);
            } finally {
                JedisUtils.returnResource(jedis);
            }
            return keys;
        }

        @SuppressWarnings("unchecked")
        @Override
        public Collection<V> values() {
            Collection<V> vals = Collections.emptyList();
            ;
            Jedis jedis = null;
            try {
                jedis = JedisUtils.getResource();
                Collection<byte[]> col = jedis.hvals(JedisUtils.getBytesKey(cacheKeyName));
                for(byte[] val : col) {
                    Object obj = JedisUtils.toObject(val);
                    if (obj != null) {
                        vals.add((V) obj);
                    }
                }
                LOGGER.debug("values {} {} ", cacheKeyName, vals);
                return vals;
            } catch(Exception e) {
                LOGGER.error("values {} {}", cacheKeyName, e);
            } finally {
                JedisUtils.returnResource(jedis);
            }
            return vals;
        }
    }
}
