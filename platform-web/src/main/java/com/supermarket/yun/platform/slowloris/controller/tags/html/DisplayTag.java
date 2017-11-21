package com.supermarket.yun.platform.slowloris.controller.tags.html;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:56
 */
public class DisplayTag extends BodyTagSupport {

    @Override
    public int doStartTag() throws JspException {
        return EVAL_PAGE;
    }

    protected String getContent() {
        BodyContent body = getBodyContent();
        String content = body.getString();
        content = StringEscapeUtils.escapeHtml4(content);
        return content;
    }

    public int doEndTag() throws JspTagException {
        try {
            JspWriter out = this.pageContext.getOut();
            out.print(getContent());
            out.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

}