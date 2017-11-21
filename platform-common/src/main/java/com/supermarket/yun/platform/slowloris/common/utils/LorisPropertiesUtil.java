package com.supermarket.yun.platform.slowloris.common.utils;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 全局配置文件工具类
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:37
 */
public class LorisPropertiesUtil extends PropertiesUtil {

    private static String JEEWE_BPROPERTIES_FILENAME = "loris.properties";

    private static LorisPropertiesUtil propertiesUtil = new LorisPropertiesUtil();

    // 保存全局属性值
    private static Map<String, String> configMap = Maps.newHashMap();

    public LorisPropertiesUtil() {
        load(JEEWE_BPROPERTIES_FILENAME);
    }

    public static LorisPropertiesUtil getProperties() {
        if (propertiesUtil != null) {
            propertiesUtil = new LorisPropertiesUtil();
        }
        return propertiesUtil;
    }

    /**
     * 获得配置
     *
     * @param key
     * @return
     */
    public static String getConfig(String key) {
        String value = configMap.get(key);
        if (value == null) {
            value = propertiesUtil.getString(key);
            configMap.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }

    /**
     * 设置配置
     *
     * @param key
     * @param value
     */
    public static void setConfig(String key, Object value) {
        propertiesUtil.set(key, value);
    }

    /**
     * 移除配置
     *
     * @param key
     * @return
     */
    public static boolean removeConfig(String key) {
        return propertiesUtil.remove(key);
    }
}
