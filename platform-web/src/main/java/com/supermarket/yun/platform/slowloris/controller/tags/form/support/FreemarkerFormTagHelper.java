package com.supermarket.yun.platform.slowloris.controller.tags.form.support;

import com.supermarket.yun.platform.slowloris.common.SysFunctions;
import com.supermarket.yun.platform.slowloris.common.utils.ObjectUtils;
import com.supermarket.yun.platform.slowloris.common.utils.Reflections;

import javax.servlet.jsp.PageContext;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:50
 */
public class FreemarkerFormTagHelper {
    protected Map<String, Object> staticAttributes = new HashMap<String, Object>();

    public static FreemarkerFormTagHelper getFormHelper() {
        return new FreemarkerFormTagHelper();
    }

    public static Map<String, Object> getTagStatic(Object tag, PageContext pageContext) {
        return new FreemarkerFormTagHelper().initFreeMarkerMap(tag, pageContext);
    }

    public Map<String, Object> initFreeMarkerMap(Object tag, PageContext pageContext) {
        Map<String, Object> rootMap = new HashMap<String, Object>();
        String ctx = pageContext.getServletContext().getContextPath();
        String adminPath = pageContext.getServletContext().getContextPath() + SysFunctions.getAdminUrlPrefix();
        String staticPath = pageContext.getServletContext().getContextPath() + "/static";
        rootMap.put("ctx", ctx);
        rootMap.put("adminPath", adminPath);
        rootMap.put("staticPath", staticPath);
        initStaticAttribute(tag);
        rootMap.putAll(staticAttributes);
        return rootMap;
    }

    public void initStaticAttribute(Object tag) {
        Field[] field = tag.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        for(int j = 0; j < field.length; j++) { // 遍历所有属性
            Field field2 = field[j];
            if (ObjectUtils.isBaseDataType(field2.getType())) {
                String name = field[j].getName(); // 获取属性的名字
                setStaticAttribute(name, Reflections.invokeGetter(tag, name));
            }
        }
    }

    // 设置静态属性
    public void setStaticAttribute(String localName, Object value) {
        if (this.staticAttributes == null) {
            this.staticAttributes = new HashMap<String, Object>();
        }
        if (!ObjectUtils.isNullOrEmpty(value)) {
            staticAttributes.put(localName, value);
        }
    }
}
