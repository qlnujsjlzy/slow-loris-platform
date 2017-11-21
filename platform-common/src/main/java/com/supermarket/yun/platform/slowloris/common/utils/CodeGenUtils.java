package com.supermarket.yun.platform.slowloris.common.utils;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:37
 */
public class CodeGenUtils {

    public static String getDbType() {
        PropertiesUtil propertiesUtil = new PropertiesUtil("dbconfig.properties");
        String dbType = propertiesUtil.getString("connection.dbType");
        return dbType.toLowerCase();
    }
}
