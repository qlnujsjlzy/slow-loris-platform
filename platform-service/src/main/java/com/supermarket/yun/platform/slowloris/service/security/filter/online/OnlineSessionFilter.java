package com.supermarket.yun.platform.slowloris.service.security.filter.online;

import com.supermarket.yun.platform.slowloris.common.domain.OnlineSession;
import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;
import com.supermarket.yun.platform.slowloris.domain.system.User;
import com.supermarket.yun.platform.slowloris.service.security.ShiroConstants;
import com.supermarket.yun.platform.slowloris.service.security.session.SessionDAO;
import com.supermarket.yun.platform.slowloris.service.utils.UserUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 在线
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:05
 */
public class OnlineSessionFilter extends AccessControlFilter {

    /**
     * 强制退出后重定向的地址
     */
    private String forceLogoutUrl;

    private SessionDAO sessionDAO;

    public String getForceLogoutUrl() {
        return forceLogoutUrl;
    }

    public void setForceLogoutUrl(String forceLogoutUrl) {
        this.forceLogoutUrl = forceLogoutUrl;
    }

    public void setSessionDAO(SessionDAO sessionDAO) {
        this.sessionDAO = sessionDAO;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        Subject subject = getSubject(request, response);
        if (subject == null || subject.getSession() == null) {
            return true;
        }
        Session session = sessionDAO.readSession(subject.getSession().getId());
        if (session != null && session instanceof OnlineSession) {
            OnlineSession onlineSession = (OnlineSession) session;
            request.setAttribute(ShiroConstants.ONLINE_SESSION, onlineSession);
            // 把user id设置进去
            //boolean isGuest = onlineSession.getUserId() == null  ;
            if (StringUtils.isEmpty(onlineSession.getUserId())) {
                User user = UserUtils.getUser();
                if (user != null) {
                    onlineSession.setUserId(user.getId());
                    onlineSession.setUsername(user.getUsername());
                    onlineSession.markAttributeChanged();
                }
            }

            if (onlineSession.getStatus() == OnlineSession.OnlineStatus.force_logout) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if (subject != null) {
            subject.logout();
        }
        saveRequestAndRedirectToLogin(request, response);
        return true;
    }

    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        WebUtils.issueRedirect(request, response, getForceLogoutUrl());
    }

}
