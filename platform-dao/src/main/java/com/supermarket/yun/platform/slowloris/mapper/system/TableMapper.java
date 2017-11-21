package com.supermarket.yun.platform.slowloris.mapper.system;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.supermarket.yun.platform.slowloris.domain.system.Table;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:41
 */
public interface TableMapper extends BaseMapper<Table> {

    /**
     * @param tablename
     * @return
     * @title: findSubTables
     * @description:通过表名获得子表信息
     * @return: List<Role>
     */
    List<Table> findSubTables(String tablename);
}