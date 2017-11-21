package com.supermarket.yun.platform.slowloris.service.security.filter.user;

import com.supermarket.yun.platform.slowloris.common.constants.Constants;
import com.supermarket.yun.platform.slowloris.domain.system.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 验证用户过滤器 1、用户是否删除 2、用户是否锁定
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:06
 */
public class SysUserFilter extends AccessControlFilter {

    /**
     * 用户删除了后重定向的地址
     */
    private String userNotfoundUrl;
    /**
     * 用户锁定后重定向的地址
     */
    private String userLockedUrl;
    /**
     * 未知错误
     */
    private String userUnknownErrorUrl;

    public String getUserNotfoundUrl() {
        return userNotfoundUrl;
    }

    public void setUserNotfoundUrl(String userNotfoundUrl) {
        this.userNotfoundUrl = userNotfoundUrl;
    }

    public String getUserLockedUrl() {
        return userLockedUrl;
    }

    public void setUserLockedUrl(String userLockedUrl) {
        this.userLockedUrl = userLockedUrl;
    }

    public String getUserUnknownErrorUrl() {
        return userUnknownErrorUrl;
    }

    public void setUserUnknownErrorUrl(String userUnknownErrorUrl) {
        this.userUnknownErrorUrl = userUnknownErrorUrl;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return true;
        }
        return true;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        User user = (User) request.getAttribute(Constants.CURRENT_USER);
        if (user == null) {
            return true;
        }

        if (User.STATUS_DELETE.equals(user.getStatus()) || User.STATUS_LOCKED.equals(user.getStatus())) {
            getSubject(request, response).logout();
            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        getSubject(request, response).logout();
        saveRequestAndRedirectToLogin(request, response);
        return true;
    }

    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        User user = (User) request.getAttribute(Constants.CURRENT_USER);
        String url = null;
        if (User.STATUS_DELETE.equals(user.getStatus())) {
            url = getUserNotfoundUrl();
        } else if (User.STATUS_LOCKED.equals(user.getStatus())) {
            url = getUserLockedUrl();
        } else {
            url = getUserUnknownErrorUrl();
        }
        WebUtils.issueRedirect(request, response, url);
    }

}
