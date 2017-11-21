package com.supermarket.yun.platform.slowloris.controller.tags.html;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:56
 */
public class FragmentComponentTag extends AbstractHtmlTag {
    private static final String[] SUPPORT_TYPES = {"FRAGMENT"};

    @Override
    public String[] getSupportTypes() {
        return SUPPORT_TYPES;
    }

}
