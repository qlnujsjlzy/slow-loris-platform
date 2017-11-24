package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.domain.system.Role;
import com.supermarket.yun.platform.slowloris.mapper.system.RoleMapper;
import com.supermarket.yun.platform.slowloris.service.system.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:11
 */
@Transactional
@Service("roleService")
public class RoleServiceImpl extends CommonServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> findListByUserId(String userid) {
        return baseMapper.findRoleByUserId(userid);
    }

}
