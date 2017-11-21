package com.supermarket.yun.platform.slowloris.service.system;

import com.supermarket.yun.platform.slowloris.domain.system.Organization;
import com.supermarket.yun.platform.slowloris.service.common.ITreeCommonService;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:13
 */
public interface IOrganizationService extends ITreeCommonService<Organization, String> {
    /**
     * 通过用户ID查找角色
     */
    public List<Organization> findListByUserId(String userid);
}
