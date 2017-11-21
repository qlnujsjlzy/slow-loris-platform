package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.domain.system.Scheme;
import com.supermarket.yun.platform.slowloris.mapper.system.SchemeMapper;
import com.supermarket.yun.platform.slowloris.service.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.service.system.ISchemeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:11
 */
@Transactional
@Service("schemeService")
public class SchemeServiceImpl extends CommonServiceImpl<SchemeMapper, Scheme> implements ISchemeService {

}
