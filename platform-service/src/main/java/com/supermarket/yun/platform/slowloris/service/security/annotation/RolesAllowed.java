package com.supermarket.yun.platform.slowloris.service.security.annotation;

import java.lang.annotation.*;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:05
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RolesAllowed {
    String[] value();
}