package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.domain.system.DataSource;
import com.supermarket.yun.platform.slowloris.mapper.system.DataSourceMapper;
import com.supermarket.yun.platform.slowloris.service.system.IDataSourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:10
 */
@Transactional
@Service("dataSourceService")
public class DataSourceServiceImpl extends CommonServiceImpl<DataSourceMapper, DataSource> implements IDataSourceService {

}
