package com.supermarket.yun.platform.slowloris.common.convert;


import org.apache.commons.text.StringEscapeUtils;

import java.beans.PropertyEditorSupport;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 19:13
 */
public class StringConvertEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "";
    }

    @Override
    public void setAsText(String text) {
        setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
    }
}
