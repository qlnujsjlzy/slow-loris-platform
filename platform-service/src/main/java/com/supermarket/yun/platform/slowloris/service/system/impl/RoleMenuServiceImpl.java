package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.domain.system.RoleMenu;
import com.supermarket.yun.platform.slowloris.mapper.system.RoleMenuMapper;
import com.supermarket.yun.platform.slowloris.service.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.service.system.IRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:11
 */
@Transactional
@Service("roleMenuService")
public class RoleMenuServiceImpl extends CommonServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
