package com.supermarket.yun.platform.slowloris.controller.tags.form;

import com.supermarket.yun.platform.slowloris.controller.tags.form.support.CustomBindStatus;
import org.springframework.beans.PropertyAccessor;
import org.springframework.web.servlet.support.BindStatus;

import javax.servlet.jsp.JspException;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:51
 */
public class HiddenInputTag extends org.springframework.web.servlet.tags.form.HiddenInputTag {

    private BindStatus bindStatus = null;
    private Boolean nested = true; // 是否嵌套使用Form自定的模型，模式为真,
    private String valueway = "";// 1,bean
    // 2,通过参数获取。3.获取getAttribute中的值
    private String defaultValue = "";// 当所有值都无效的时候，是由默认值

    @Override
    protected BindStatus getBindStatus() throws JspException {
        if (this.bindStatus == null) {
            // HTML escaping in tags is performed by the ValueFormatter class.
            String nestedPath = "";
            if (nested) {
                nestedPath = getNestedPath();
            }
            String pathToUse = (nestedPath != null ? nestedPath + getPath() : getPath());
            if (pathToUse.endsWith(PropertyAccessor.NESTED_PROPERTY_SEPARATOR)) {
                pathToUse = pathToUse.substring(0, pathToUse.length() - 1);
            }
            this.bindStatus = CustomBindStatus.create(pageContext, pathToUse, getRequestContext(), false, nested,
                    valueway, defaultValue);
        }
        return this.bindStatus;
    }

    public Boolean getNested() {
        return nested;
    }

    public void setNested(Boolean nested) {
        this.nested = nested;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getValueway() {
        return valueway;
    }

    public void setValueway(String valueway) {
        this.valueway = valueway;
    }

    @Override
    public void doFinally() {
        super.doFinally();
        this.bindStatus = null;
    }

}
