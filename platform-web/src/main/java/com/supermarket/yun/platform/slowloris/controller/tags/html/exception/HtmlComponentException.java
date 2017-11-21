package com.supermarket.yun.platform.slowloris.controller.tags.html.exception;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:55
 */
public class HtmlComponentException extends RuntimeException {

    public HtmlComponentException() {
        super();
    }

    public HtmlComponentException(String msg) {
        super(msg);
    }

    public HtmlComponentException(Exception exception) {
        super(exception);
    }
}
