package com.supermarket.yun.platform.slowloris.service.security.filter.authc;

/**
 * 用户和密码（包含验证码）令牌类
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:04
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

    private static final long serialVersionUID = 1L;

    private String captcha;
    private boolean mobileLogin;

    public UsernamePasswordToken() {
        super();
    }

    public UsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha,
                                 boolean mobileLogin) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
        this.mobileLogin = mobileLogin;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public boolean isMobileLogin() {
        return mobileLogin;
    }

}