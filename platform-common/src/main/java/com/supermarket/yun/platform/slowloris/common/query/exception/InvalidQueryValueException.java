package com.supermarket.yun.platform.slowloris.common.query.exception;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 0:47
 */
public final class InvalidQueryValueException extends QueryException {

    public InvalidQueryValueException(String property, Object value) {
        this(property, value, null);
    }

    public InvalidQueryValueException(String property, Object value, Throwable cause) {
        super("Invalid Query Value, queryProperty [" + property + "], value [" + value + "]", cause);
    }

}
