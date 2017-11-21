package com.supermarket.yun.platform.slowloris.controller.tags.html.listener;

import com.supermarket.yun.platform.slowloris.common.utils.SpringContextHolder;
import com.supermarket.yun.platform.slowloris.controller.tags.html.manager.HtmlComponentManager;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:55
 */
public class HtmlComponentInitListener implements ApplicationListener<ContextRefreshedEvent> {
    protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
            .getBean(HtmlComponentManager.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            htmlComponentManager.init();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}