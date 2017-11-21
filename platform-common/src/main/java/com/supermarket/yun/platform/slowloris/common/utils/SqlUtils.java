package com.supermarket.yun.platform.slowloris.common.utils;


import com.supermarket.yun.platform.slowloris.common.xml.definition.Sql;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:39
 */
public class SqlUtils {

    public static SqlUtils sqlUtils = null;
    private Map<String, Sql> sqlMap = new HashMap<String, Sql>();

    public SqlUtils() {
        for(Sql sql : DefinitionUtils.getDefinitionUtils().getDefinition().getDb().getSql()) {
            sqlMap.put(sql.getId(), sql);
        }
    }

    public static SqlUtils getSqlUtils() {
        if (sqlUtils == null) {
            sqlUtils = new SqlUtils();
        }
        return sqlUtils;
    }

    public Sql getSqlByID(String sqlId) {
        return sqlMap.get(sqlId);
    }

    public String getSqlContent(String sqlId, Map<String, Object> data) {
        Sql sql = sqlMap.get(sqlId);
        String content = sql.getContent();
        for(String key : data.keySet()) {
            content = content.replaceAll("\\$\\{".concat(key).concat("\\}"), data.get(key).toString());
        }
        return content;
    }

}
