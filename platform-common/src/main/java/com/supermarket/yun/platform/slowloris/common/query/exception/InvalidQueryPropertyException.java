package com.supermarket.yun.platform.slowloris.common.query.exception;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 0:47
 */
public final class InvalidQueryPropertyException extends QueryException {

    public InvalidQueryPropertyException(String property) {
        this(property, null);
    }

    public InvalidQueryPropertyException(String property, Throwable cause) {
        super("Invalid Query Property [" + property + "]", cause);
    }

}
