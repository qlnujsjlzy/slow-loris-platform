package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.domain.system.UserRole;
import com.supermarket.yun.platform.slowloris.mapper.system.UserRoleMapper;
import com.supermarket.yun.platform.slowloris.service.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.service.system.IUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:12
 */
@Transactional
@Service("userRoleService")
public class UserRoleServiceImpl extends CommonServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
