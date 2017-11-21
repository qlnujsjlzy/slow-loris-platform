package com.supermarket.yun.platform.slowloris.controller.utils.sms.sender;


import com.supermarket.yun.platform.slowloris.controller.utils.sms.data.SmsResult;
import com.supermarket.yun.platform.slowloris.controller.utils.sms.data.SmsTemplate;

/**
 * 短信发射器
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:56
 */
public abstract class SmsSender {
    public static final String DEFAULT_CONFIG_FILE = "sms.properties";
    protected String configname = DEFAULT_CONFIG_FILE;

    public String getConfigname() {
        return configname;
    }

    public void setConfigname(String configname) {
        this.configname = configname;
    }

    /**
     * 初始化配置
     */
    protected abstract void init();

    /**
     * @title: name
     * @description:发射器名称
     * @return: void
     */
    protected abstract String name();

    /**
     * @param phone      手机号码
     * @param templateId 模版ID
     * @param datas      数据
     * @return
     */
    public abstract SmsResult send(String phone, SmsTemplate smsTemplate, String... datas);

}
