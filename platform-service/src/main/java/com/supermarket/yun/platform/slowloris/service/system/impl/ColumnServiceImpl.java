package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.common.query.wrapper.EntityWrapper;
import com.supermarket.yun.platform.slowloris.domain.system.Column;
import com.supermarket.yun.platform.slowloris.mapper.system.ColumnMapper;
import com.supermarket.yun.platform.slowloris.service.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.service.system.IColumnService;
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
@Service("columnService")
public class ColumnServiceImpl extends CommonServiceImpl<ColumnMapper, Column> implements IColumnService {

    @Override
    public List<Column> selectListByTableId(String tableId) {
        EntityWrapper<Column> columnWrapper = new EntityWrapper<Column>(Column.class);
        columnWrapper.eq("table.id", tableId);
        columnWrapper.orderBy("sort");
        List<Column> oldColumnList = selectList(columnWrapper);
        return oldColumnList;
    }

}
