package com.supermarket.yun.platform.slowloris.mapper.system;

import com.supermarket.yun.platform.slowloris.common.base.BaseTreeMapper;
import com.supermarket.yun.platform.slowloris.domain.system.Organization;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:50
 */
public interface OrganizationMapper extends BaseTreeMapper<Organization> {

    /**
     * @param userId
     * @return
     * @title: findListByUserId
     * @description: 通过用户查找组织机构
     * @return: List<Organization>
     */
    List<Organization> findListByUserId(String userId);
}