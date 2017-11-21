package com.supermarket.yun.platform.slowloris.common.convert;


import com.supermarket.yun.platform.slowloris.common.utils.DateUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 17:55
 */
public class DateConvertEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            try {
                setValue(DateUtils.parseDate(text));
            } catch(Exception ex) {
                IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
                iae.initCause(ex);
                throw iae;
            }
        } else {
            setValue(null);
        }
    }
}