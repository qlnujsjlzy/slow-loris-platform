package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.domain.system.Dict;
import com.supermarket.yun.platform.slowloris.mapper.system.DictMapper;
import com.supermarket.yun.platform.slowloris.service.system.IDictService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:10
 */
@Transactional
@Service("dictService")
public class DictServiceImpl extends CommonServiceImpl<DictMapper, Dict> implements IDictService {

    @Override
    public List<Dict> selectDictList() {
        return baseMapper.selectDictList();
    }

}
