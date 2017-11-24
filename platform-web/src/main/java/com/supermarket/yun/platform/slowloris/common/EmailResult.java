package com.supermarket.yun.platform.slowloris.common;


import com.supermarket.yun.platform.slowloris.common.query.mapper.JsonMapper;

import java.io.Serializable;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:44
 */
public class EmailResult implements Serializable {

    private String msg; // 返回消息
    private Boolean success;// 是否成功

    public static EmailResult fail(String msg) {
        EmailResult emailResult = new EmailResult();
        emailResult.setSuccess(Boolean.FALSE);
        emailResult.setMsg(msg);
        return emailResult;
    }

    public static EmailResult success(String msg) {
        EmailResult emailResult = new EmailResult();
        emailResult.setSuccess(Boolean.TRUE);
        emailResult.setMsg(msg);
        return emailResult;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return JsonMapper.toJsonString(this);
    }
}
