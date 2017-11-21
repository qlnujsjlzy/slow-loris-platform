package com.supermarket.yun.platform.slowloris.controller.utils.sms;


import com.supermarket.yun.platform.slowloris.controller.utils.sms.data.SmsResult;
import com.supermarket.yun.platform.slowloris.controller.utils.sms.data.SmsTemplate;
import com.supermarket.yun.platform.slowloris.controller.utils.sms.exception.NullException;
import com.supermarket.yun.platform.slowloris.controller.utils.sms.sender.SmsSender;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:59
 */
public class SmsManager {
    public static final SmsSender DEFAULT_SMS_SENDER = null;//new HuyiSmsSender();
    public static SmsManager smsManager;
    protected SmsSender smsSender = DEFAULT_SMS_SENDER;

    public SmsManager() {
        init();
    }

    public SmsManager(SmsSender smsSender) {
        setSmsSender(smsSender);
        init();
    }

    public static SmsManager getSmsManager() {
        if (smsManager == null) {
            smsManager = new SmsManager();
        }
        return smsManager;
    }

    public void init() {
        if (smsSender == null) {
            smsSender = DEFAULT_SMS_SENDER;
        }
    }

    public SmsSender getSmsSender() {
        return smsSender;
    }

    public void setSmsSender(SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    /**
     * @param phone      手机号码
     * @param templateId 模版ID
     * @param datas      数据
     * @return
     * @throws SendException
     * @throws NullException
     */
    public SmsResult send(String phone, SmsTemplate smsTemplate, String... datas) throws NullException {
        if (smsSender == null) {
            throw new NullException("短信发送器不存在");
        }
        return smsSender.send(phone, smsTemplate, datas);
    }
}
