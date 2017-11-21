package com.supermarket.yun.platform.slowloris.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:36
 */
public class ArrayUtils extends org.apache.commons.lang3.ArrayUtils {
    public static List<String> split(final String str, final String separatorChar) {
        List<String> strList = new ArrayList<String>();
        String[] strs = StringUtils.split(str, separatorChar);
        for(String string : strs) {
            strList.add(string);
        }
        return strList;
    }
}
