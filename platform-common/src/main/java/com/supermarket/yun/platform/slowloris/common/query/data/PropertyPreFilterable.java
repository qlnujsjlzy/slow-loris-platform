package com.supermarket.yun.platform.slowloris.common.query.data;

import com.alibaba.fastjson.serializer.SerializeFilter;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 0:47
 */
public interface PropertyPreFilterable {

    public SerializeFilter constructFilter(Class<?> clazz);

    public void addQueryProperty(String... properties);

    public void addIncludeFilter(Class<?> clazz, String... properties);

    public void addExcludeFilter(Class<?> clazz, String... properties);
}
