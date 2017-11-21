package com.supermarket.yun.platform.slowloris.common.convert;


import com.supermarket.yun.platform.slowloris.common.xml.definition.Type;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:31
 */
public interface ITypeConvert {
    public Type getType(String type);

    public List<Type> getTypes();

    public List<String> getJavaTypes();

    public List<String> getFullTypes();

    public List<String> getDbTypes();
}
