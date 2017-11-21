package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.domain.system.UserLastOnline;
import com.supermarket.yun.platform.slowloris.mapper.system.UserLastOnlineMapper;
import com.supermarket.yun.platform.slowloris.service.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.service.system.IUserLastOnlineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:11
 */
@Transactional
@Service("userLastOnlineService")
public class UserLastOnlineServiceImpl extends CommonServiceImpl<UserLastOnlineMapper, UserLastOnline> implements IUserLastOnlineService {

}
