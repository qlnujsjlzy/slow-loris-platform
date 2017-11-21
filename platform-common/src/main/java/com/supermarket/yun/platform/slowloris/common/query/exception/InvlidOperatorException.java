package com.supermarket.yun.platform.slowloris.common.query.exception;

import com.supermarket.yun.platform.slowloris.common.query.data.Condition.Operator;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 0:47
 */
public final class InvlidOperatorException extends QueryException {

    public InvlidOperatorException(String property, String operatorStr) {
        this(property, operatorStr, null);
    }

    public InvlidOperatorException(String property, String operatorStr, Throwable cause) {
        super("Invalid   Operator property [" + property + "], " + "operator [" + operatorStr + "], must be one of "
                + Operator.toStringAllOperator(), cause);
    }
}
