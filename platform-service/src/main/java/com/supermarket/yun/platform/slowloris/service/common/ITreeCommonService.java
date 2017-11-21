package com.supermarket.yun.platform.slowloris.service.common;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.supermarket.yun.platform.slowloris.common.base.TreeNode;
import com.supermarket.yun.platform.slowloris.common.query.data.Queryable;

import java.io.Serializable;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:03
 */
public interface ITreeCommonService<T extends Serializable & TreeNode<ID>, ID extends Serializable> extends ICommonService<T> {

    public List<T> selectTreeList(Wrapper<T> wrapper);

    public List<T> selectTreeList(Queryable queryable, Wrapper<T> wrapper);
}