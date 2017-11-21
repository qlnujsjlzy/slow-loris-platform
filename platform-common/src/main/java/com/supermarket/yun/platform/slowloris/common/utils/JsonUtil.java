package com.supermarket.yun.platform.slowloris.common.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:21
 */
public class JsonUtil {

    public static final ObjectMapper OM = new ObjectMapper();
    private static Logger LOGGER = LogManager.getLogger();

    static {
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        OM.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        OM.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        OM.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    }


    public static JavaType assignList(Class<? extends Collection> collection, Class<? extends Object> object) {
        return JsonUtil.OM.getTypeFactory().constructParametricType(collection, object);
    }


    public static <T> ArrayList<T> readValuesAsArrayList(String key, Class<T> object) {
        ArrayList<T> list = null;
        try {
            list = OM.readValue(key, assignList(ArrayList.class, object));
        } catch(Exception e) {
            LOGGER.error("JsonUtil readValuesAsArrayList  error", e);
        }
        return list;
    }


    public static String toJson(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return OM.writeValueAsString(obj);
        } catch(Exception e) {
            LOGGER.error("JsonUtil toJson  error", e);
        }
        return null;
    }


    public static <T> T fromJson(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return OM.readValue(json, clazz);
        } catch(Exception e) {
            LOGGER.error("JsonUtil fromJson  error", e);
        }
        return null;
    }

    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return OM.readValue(json, typeReference);
        } catch(Exception e) {
            LOGGER.error("JsonUtil fromJson  error", e);
        }
        return null;
    }


    /**
     * 格式化json
     *
     * @param content
     * @return
     */
    public static String formatJson(String content) {

        StringBuffer sb = new StringBuffer();
        int index = 0;
        int count = 0;
        while(index < content.length()) {
            char ch = content.charAt(index);
            if (ch == '{' || ch == '[') {
                sb.append(ch);
                sb.append('\n');
                count++;
                for(int i = 0; i < count; i++) {
                    sb.append('\t');
                }
            } else if (ch == '}' || ch == ']') {
                sb.append('\n');
                count--;
                for(int i = 0; i < count; i++) {
                    sb.append('\t');
                }
                sb.append(ch);
            } else if (ch == ',') {
                sb.append(ch);
                sb.append('\n');
                for(int i = 0; i < count; i++) {
                    sb.append('\t');
                }
            } else {
                sb.append(ch);
            }
            index++;
        }
        return sb.toString();
    }

    /**
     * 把格式化的json紧凑
     *
     * @param content
     * @return
     */
    public static String compactJson(String content) {
        String regEx = "[\t\n]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        return m.replaceAll("").trim();
    }

    public static void main(String[] args) {
        String str = "{\"chargeAcct\":\"18766143231\",\"chargeCash\":\"充值500M\",\"chargeType\":1,\"flowPackageType\":0,\"flowPackageSize\":\"充值500M\",\"ispName\":\"移动\",\"belong\":\"山东移动\"}";
        Map map = JsonUtil.fromJson(str, Map.class);
        String chargeAcct = (String) map.get("chargeAcct");
        String chargeType = String.valueOf(map.get("chargeType"));
        System.out.println(formatJson(str));
        System.out.println(compactJson(formatJson(str)));
    }

}
