package com.supermarket.yun.platform.slowloris.controller.tags.html.builder;

import java.io.IOException;
import java.util.Map;

/**
 * 组建构造器具
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:01
 */
public interface HtmlComponentBuilder {
    /**
     * JSMap
     *
     * @return
     */
    public Map<String, String> getJsComponents();

    /**
     * css语句map
     *
     * @return
     */
    public Map<String, String> getCssComponents();

    /**
     * html语句map
     *
     * @return
     */
    public Map<String, String> getFragmentComponents();

    /**
     * 初始化
     *
     * @throws IOException
     */
    public void init() throws IOException;
}