package com.supermarket.yun.platform.slowloris.controller.system;

import com.supermarket.yun.platform.slowloris.common.BaseController;
import com.supermarket.yun.platform.slowloris.security.exception.RepeatAuthenticationException;
import com.supermarket.yun.platform.slowloris.security.filter.authc.FormAuthenticationFilter;
import com.supermarket.yun.platform.slowloris.security.filter.authc.credential.RetryLimitHashedCredentialsMatcher;
import com.supermarket.yun.platform.slowloris.security.realm.UserRealm;
import com.supermarket.yun.platform.slowloris.service.utils.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:47
 */
@Controller
@RequestMapping("${admin.url.prefix}")
public class LoginController extends BaseController {
    @Autowired
    private RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher;

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, HttpServletRequest response, Model model) {
        // 我的电脑有缓存问题
        UserRealm.Principal principal = UserUtils.getPrincipal(); // 如果已经登录，则跳转到管理首页
        if (principal != null && !principal.isMobileLogin()) {
            return new ModelAndView("redirect:/admin");
        }

        String useruame = WebUtils.getCleanParam(request, FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
        //boolean rememberMe = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
        //	boolean mobile = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_MOBILE_PARAM);
        String exception = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        //	String message = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_MESSAGE_ERROR_PARAM);
        //	useruame = "admin";
        // 是否开启验证码
        if (RepeatAuthenticationException.class.getName().equals(exception)
                || retryLimitHashedCredentialsMatcher.isShowCaptcha(useruame)) { // 重复认证异常加入验证码。
            model.addAttribute("showCaptcha", "1");
        } else {
            model.addAttribute("showCaptcha", "0");
        }

        // 强制登陆跳转
        if (ExcessiveAttemptsException.class.getName().equals(exception)
                || retryLimitHashedCredentialsMatcher.isForceLogin(useruame)) { // 重复认证异常加入验证码。
            // model.addAttribute("showCaptcha", "1");
        }

        return new ModelAndView("modules/sys/login/login2");
    }

    @RequestMapping("/logout")
    public ModelAndView logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            if (subject != null && subject.isAuthenticated()) {
                subject.logout();
            }
            return new ModelAndView("modules/sys/login/login2");
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("modules/sys/login/index");
    }

}
