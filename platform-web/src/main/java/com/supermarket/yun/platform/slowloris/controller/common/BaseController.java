package com.supermarket.yun.platform.slowloris.controller.common;

import com.supermarket.yun.platform.slowloris.common.convert.DateConvertEditor;
import com.supermarket.yun.platform.slowloris.common.convert.StringConvertEditor;
import com.supermarket.yun.platform.slowloris.common.utils.JsonUtil;
import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 23:37
 */
public class BaseController {

    private final static Logger LOGGER = LogManager.getLogger();

    private String viewPrefix;


    protected BaseController() {
        setViewPrefix(defaultViewPrefix());
    }

    /**
     * 初始化数据绑定
     *
     * @param binder
     */
    @InitBinder
    void initBinder(ServletRequestDataBinder binder) {
        // 将所有传递进来的String进行HTML编码，防止XSS攻击
        // 这个会导致数据库数据
        binder.registerCustomEditor(String.class, new StringConvertEditor());
        // 日期格式
        binder.registerCustomEditor(Date.class, new DateConvertEditor());
    }

    /**
     * 返回JSON字符串
     *
     * @param response
     * @param object
     * @return
     */
    protected void printString(HttpServletResponse response, Object object) {
        printString(response, JsonUtil.toJson(object));
    }

    /**
     * 打印字符串到页面
     *
     * @param response
     * @param string
     * @return
     */
    private void printString(HttpServletResponse response, String string) {
        try {
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch(IOException e) {
            LOGGER.error("printString error", e);
        }
    }

    public String getViewPrefix() {
        return viewPrefix;
    }

    /**
     * 当前模块 视图的前缀 默认 1、获取当前类头上的@RequestMapping中的value作为前缀 2、如果没有就使用当前模型小写的简单类名
     */
    public void setViewPrefix(String viewPrefix) {
        if (viewPrefix.startsWith("/")) {
            viewPrefix = viewPrefix.substring(1);
        }
        this.viewPrefix = viewPrefix;
    }

    /**
     * 获取视图名称：即prefixViewName + "/" + suffixName
     *
     * @return
     */
    public String display(String suffixName) {
        if (!suffixName.startsWith("/")) {
            suffixName = "/" + suffixName;
        }
        return getViewPrefix().toLowerCase() + suffixName;
    }

    protected String defaultViewPrefix() {
        String currentViewPrefix = "";
        RequestMapping requestMapping = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class);
        if (requestMapping != null && requestMapping.value().length > 0) {
            currentViewPrefix = requestMapping.value()[0];
            // 替换${admin.url.prefix}
            currentViewPrefix = currentViewPrefix.replace("${admin.url.prefix}", "modules");
        }
        if (StringUtils.isEmpty(currentViewPrefix)) {
            currentViewPrefix = this.getClass().getSimpleName().replace("Controller", "").toLowerCase();
        }

        return currentViewPrefix;
    }

}

