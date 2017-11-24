package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.common.impl.TreeCommonServiceImpl;
import com.supermarket.yun.platform.slowloris.domain.system.Menu;
import com.supermarket.yun.platform.slowloris.mapper.system.MenuMapper;
import com.supermarket.yun.platform.slowloris.service.system.IMenuService;
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
@Service("menuService")
public class MenuServiceImpl extends TreeCommonServiceImpl<MenuMapper, Menu, String> implements IMenuService {

    @Override
    public List<Menu> findMenuByUserId(String userId) {
        return baseMapper.findMenuByUserId(userId);
    }

    @Override
    public List<Menu> findMenuByRoleId(String roleId) {
        return baseMapper.findMenuByRoleId(roleId);
    }

}
