package com.supermarket.yun.platform.slowloris.mapper.system;

import com.supermarket.yun.platform.slowloris.common.base.BaseTreeMapper;
import com.supermarket.yun.platform.slowloris.domain.system.Menu;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:49
 */
public interface MenuMapper extends BaseTreeMapper<Menu> {

    /**
     * @param userId
     * @title: findMenuByUserId
     * @description: 通过用户查找菜单
     * @return: List<Menu>
     */
    List<Menu> findMenuByUserId(String userId);

    /**
     * @param roleId
     * @title: findMenuByRoleId
     * @description: 通过角色查找菜单
     * @return: List<Menu>
     */
    List<Menu> findMenuByRoleId(String roleId);
}