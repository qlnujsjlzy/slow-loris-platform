package com.supermarket.yun.platform.slowloris.common.domain;

/**
 * 重复验证
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 1:04
 */
public class DuplicateValid implements java.io.Serializable {

    /**
     * 字段名
     */
    private String name;

    /**
     * 字段值
     */
    private String param;

    /**
     * 字段名
     */
    private String extendName;

    /**
     * 字段值
     */
    private String extendParam;
    /**
     * 查询方式
     */
    private String queryType;
    /**
     * 查询的DATA
     */
    private String queryData;

    private String errorMsg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getQueryData() {
        return queryData;
    }

    public void setQueryData(String queryData) {
        this.queryData = queryData;
    }

    public String getExtendName() {
        return extendName;
    }

    public void setExtendName(String extendName) {
        this.extendName = extendName;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public void setExtendParam(String extendParam) {
        this.extendParam = extendParam;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}