package com.supermarket.yun.platform.slowloris.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.supermarket.yun.platform.slowloris.domain.system.Dict;

import java.util.List;

/**
 * 字典 接口
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:49
 */
public interface DictMapper extends BaseMapper<Dict> {
    /**
     * 获取字典 和分组两列表
     *
     * @return
     */
    List<Dict> selectDictList();
}