package com.supermarket.yun.platform.slowloris.controller.tags.html.builder;

import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.Map;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:55
 */
public class NoneHtmlComponentBuilder implements HtmlComponentBuilder {

    @Override
    public Map<String, String> getJsComponents() {
        return Maps.newHashMap();
    }

    @Override
    public Map<String, String> getCssComponents() {
        return Maps.newHashMap();
    }

    @Override
    public void init() throws IOException {

    }

    @Override
    public Map<String, String> getFragmentComponents() {
        return Maps.newHashMap();
    }

}
