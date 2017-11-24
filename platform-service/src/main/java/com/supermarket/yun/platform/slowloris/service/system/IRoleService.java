package com.supermarket.yun.platform.slowloris.service.system;


import com.supermarket.yun.platform.slowloris.common.ICommonService;
import com.supermarket.yun.platform.slowloris.domain.system.Role;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:13
 */
public interface IRoleService extends ICommonService<Role> {
    /**
     * 通过用户ID查找角色
     */
    public List<Role> findListByUserId(String userid);
}
