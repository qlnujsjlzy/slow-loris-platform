package com.supermarket.yun.platform.slowloris.common.query.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 0:47
 */
public class QueryException extends NestedRuntimeException {

    private static final long serialVersionUID = 4643233133664774145L;

    public QueryException(String msg) {
        super(msg);
    }

    public QueryException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
