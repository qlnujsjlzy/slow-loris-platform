package com.supermarket.yun.platform.slowloris.service.system;

import com.supermarket.yun.platform.slowloris.domain.system.Dict;
import com.supermarket.yun.platform.slowloris.service.common.ICommonService;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:12
 */
public interface IDictService extends ICommonService<Dict> {
    public List<Dict> selectDictList();
}
