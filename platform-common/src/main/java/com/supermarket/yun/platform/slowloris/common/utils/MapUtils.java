package com.supermarket.yun.platform.slowloris.common.utils;

import java.util.Map;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:38
 */
public class MapUtils extends org.apache.commons.collections.MapUtils {

    public static Boolean containsAndKeys(Map<String, Object> dataMap, String[] keys) {
        for(String key : keys) {
            if (!dataMap.containsKey(key)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static Boolean containsOrKeys(Map<String, Object> dataMap, String[] keys) {
        for(String key : keys) {
            if (dataMap.containsKey(key)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
