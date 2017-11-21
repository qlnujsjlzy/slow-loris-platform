package com.supermarket.yun.platform.slowloris.common.base;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 22:09
 */
public interface BaseTreeMapper<T> extends BaseMapper<T> {
    /**
     * @param id
     * @return
     * @title: selectByPrimaryKey
     * @description: 查找主键
     * @return: Menu
     */
    T selectByTreeId(Serializable id);

    /**
     * @param wrapper
     * @return
     * @title: selectTreeList
     * @description: 查找列表
     * @return: List<T>
     */
    List<T> selectTreeList(@Param("ew") Wrapper<T> wrapper);

    /**
     * @param newParentIds
     * @param oldParentIds
     * @title: updateSunTreeParentId
     * @description: 更新ParentIds
     * @return: void
     */
    void updateSunTreeParentIds(@Param("newParentIds") String newParentIds, @Param("oldParentIds") String oldParentIds);

    /**
     * @param parentIds
     * @return
     * @title: deleteSunTree
     * @description: 删除ParentIds
     * @return: void
     */
    void deleteSunTree(String parentIds);

}