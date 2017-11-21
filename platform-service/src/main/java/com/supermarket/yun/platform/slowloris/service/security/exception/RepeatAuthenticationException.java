package com.supermarket.yun.platform.slowloris.service.security.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 重复认证异常
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:03
 */
public class RepeatAuthenticationException extends AuthenticationException {

    public RepeatAuthenticationException() {
        super();
    }

    public RepeatAuthenticationException(String message) {
        super(message);
    }

    public RepeatAuthenticationException(Throwable cause) {
        super(cause);
    }

    public RepeatAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
