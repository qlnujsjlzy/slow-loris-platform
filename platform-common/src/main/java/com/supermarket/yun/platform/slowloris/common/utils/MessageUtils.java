package com.supermarket.yun.platform.slowloris.common.utils;

import org.springframework.context.MessageSource;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 21:25
 */
public class MessageUtils {

    private static MessageSource messageSource;

    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String getMessage(String code, Object... args) {
        if (messageSource == null) {
            messageSource = SpringContextHolder.getBean(MessageSource.class);
        }
        return messageSource.getMessage(code, args, null);
    }

    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String getMessage(String code, String defaultMessage, Object... args) {
        if (messageSource == null) {
            messageSource = SpringContextHolder.getBean(MessageSource.class);
        }
        return messageSource.getMessage(code, args, defaultMessage, null);
    }

    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String getMessageOrSelf(String code, Object... args) {
        String message = "";
        try {
            message = getMessage(code, args, code);
        } catch(Exception e) {
            message = code;
        }
        return message;
    }

}
