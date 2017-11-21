package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.domain.system.OaNotification;
import com.supermarket.yun.platform.slowloris.mapper.system.OaNotificationMapper;
import com.supermarket.yun.platform.slowloris.service.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.service.system.IOaNotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:11
 */
@Transactional
@Service("oaNotificationService")
public class OaNotificationServiceImpl extends CommonServiceImpl<OaNotificationMapper, OaNotification> implements IOaNotificationService {

}
