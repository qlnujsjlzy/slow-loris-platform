package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.domain.system.Organization;
import com.supermarket.yun.platform.slowloris.mapper.system.OrganizationMapper;
import com.supermarket.yun.platform.slowloris.service.common.impl.TreeCommonServiceImpl;
import com.supermarket.yun.platform.slowloris.service.system.IOrganizationService;
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
@Service("organizationService")
public class OrganizationServiceImpl extends TreeCommonServiceImpl<OrganizationMapper, Organization, String>
        implements IOrganizationService {

    @Override
    public List<Organization> findListByUserId(String userid) {
        return baseMapper.findListByUserId(userid);
    }

}
