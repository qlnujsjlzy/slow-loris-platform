package com.supermarket.yun.platform.slowloris.service.system;

import com.supermarket.yun.platform.slowloris.domain.system.Menu;
import com.supermarket.yun.platform.slowloris.service.common.ITreeCommonService;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:12
 */
public interface IMenuService extends ITreeCommonService<Menu, String> {

    /**
     * 通过用户ID查找菜单
     *
     * @return
     */
    List<Menu> findMenuByUserId(String userId);

    /**
     * 通过角色查找菜单
     *
     * @return
     */
    List<Menu> findMenuByRoleId(String roleId);
}
