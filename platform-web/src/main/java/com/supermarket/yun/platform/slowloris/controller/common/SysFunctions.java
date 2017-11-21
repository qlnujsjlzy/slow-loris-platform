package com.supermarket.yun.platform.slowloris.controller.common;


import com.supermarket.yun.platform.slowloris.common.utils.LorisPropertiesUtil;
import com.supermarket.yun.platform.slowloris.common.utils.ServletUtils;
import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;

import javax.servlet.http.Cookie;

/**
 * 公用的函数
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:44
 */
public class SysFunctions {
    /**
     * 获得后台地址
     *
     * @return
     * @title: getAdminUrlPrefix
     * @description: 获得后台地址
     * @return: String
     */
    public static String getAdminUrlPrefix() {
        String adminUrlPrefix = LorisPropertiesUtil.getConfig("admin.url.prefix");
        return adminUrlPrefix;
    }

    /**
     * 获得后台地址
     *
     * @return
     * @title: getAdminUrlPrefix
     * @description: 获得后台地址
     * @return: String
     */
    public static String get() {
        String adminUrlPrefix = LorisPropertiesUtil.getConfig("admin.url.prefix");
        return adminUrlPrefix;
    }

    /**
     * 加载风格
     *
     * @return
     * @title: getTheme
     * @description: TODO(这里用一句话描述这个方法的作用)
     * @return: String
     */
    public static String getTheme() {
        // 默认风格
        String theme = LorisPropertiesUtil.getConfig("admin.default.theme");
        if (StringUtils.isEmpty(theme)) {
            theme = "uadmin";
        }
        // cookies配置中的模版
        Cookie[] cookies = ServletUtils.getRequest().getCookies();
        for(Cookie cookie : cookies) {
            if (cookie == null || StringUtils.isEmpty(cookie.getName())) {
                continue;
            }
            if (cookie.getName().equalsIgnoreCase("theme")) {
                theme = cookie.getValue();
            }
        }
        return theme;
    }
}
