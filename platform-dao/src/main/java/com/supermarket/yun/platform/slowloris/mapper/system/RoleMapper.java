package com.supermarket.yun.platform.slowloris.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.supermarket.yun.platform.slowloris.domain.system.Role;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:50
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * @param userId
     * @title: findRoleByUserId
     * @description: 通过用户查找角色
     * @return: List<Role>
     */
    List<Role> findRoleByUserId(String userId);
}