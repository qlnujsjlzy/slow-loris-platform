package com.supermarket.yun.platform.slowloris.common.convert.impl;


import com.supermarket.yun.platform.slowloris.common.convert.ITypeConvert;
import com.supermarket.yun.platform.slowloris.common.utils.DefinitionUtils;
import com.supermarket.yun.platform.slowloris.common.xml.definition.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:31
 */
public class DbTypeConvert implements ITypeConvert {
    public final static String TYPE_DB_TO_JAVA = "dbtojava";
    // public final static String TYPE_JAVA_TO_DB = "javatodb";
    public final static String TYPE_JAVA_TO_HIBERNATE = "javatohibernate";
    public final static String JAVA_TO_CLASS = "javatoclass";
    public static Map<String, DbTypeConvert> dbTypeConvertMap = new HashMap<String, DbTypeConvert>();
    public Map<String, Type> typeMap = new HashMap<String, Type>();
    public List<Type> typeList = new ArrayList<Type>();

    public DbTypeConvert(String convertType) {
        if (convertType.equals(TYPE_DB_TO_JAVA)) {
            for(Type type : DefinitionUtils.getDefinitionUtils().getDefinition().getDbtojavaTypes()) {
                typeMap.put(type.getDbType(), type);
                typeList.add(type);
            }
        } else {
            for(Type type : DefinitionUtils.getDefinitionUtils().getDefinition().getJavatoclassTypes()) {
                typeMap.put(type.getJavaType(), type);
                typeList.add(type);
            }
        }
    }

    public static ITypeConvert getTypeConvert(String type) {
        if (dbTypeConvertMap.containsKey(type)) {
            return dbTypeConvertMap.get(type);
        } else {
            DbTypeConvert typeConvert = new DbTypeConvert(type);
            dbTypeConvertMap.put(type, typeConvert);
            return typeConvert;
        }
    }

    @Override
    public Type getType(String type) {
        return typeMap.get(type);
    }

    @Override
    public List<Type> getTypes() {
        return typeList;
    }

    @Override
    public List<String> getJavaTypes() {
        List<String> list = new ArrayList<String>();
        for(Map.Entry<String, Type> m : typeMap.entrySet()) {
            Type type = m.getValue();
            if (!list.contains(type.getJavaType())) {
                list.add(type.getJavaType());
            }
        }
        return list;
    }

    @Override
    public List<String> getFullTypes() {
        List<String> list = new ArrayList<String>();
        for(Map.Entry<String, Type> m : typeMap.entrySet()) {
            Type type = m.getValue();
            if (!list.contains(type.getFullType())) {
                list.add(type.getFullType());
            }
        }
        return list;
    }

    @Override
    public List<String> getDbTypes() {
        List<String> list = new ArrayList<String>();
        for(Map.Entry<String, Type> m : typeMap.entrySet()) {
            Type type = m.getValue();
            if (!list.contains(type.getDbType())) {
                list.add(type.getDbType());
            }
        }
        return list;
    }

}
