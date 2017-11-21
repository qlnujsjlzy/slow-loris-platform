package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.supermarket.yun.platform.slowloris.domain.system.Log;
import com.supermarket.yun.platform.slowloris.mapper.system.LogMapper;
import com.supermarket.yun.platform.slowloris.service.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.service.system.ILogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:10
 */
@Transactional
@Service("logService")
public class LogServiceImpl extends CommonServiceImpl<LogMapper, Log> implements ILogService {
    @Override
    public Page<Log> selectPage(Page<Log> page, Wrapper<Log> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectLogPage(page, wrapper));
        return page;
    }
}
