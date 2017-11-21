package com.supermarket.yun.platform.slowloris.service.common;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.supermarket.yun.platform.slowloris.common.domain.DuplicateValid;
import com.supermarket.yun.platform.slowloris.common.query.data.Page;
import com.supermarket.yun.platform.slowloris.common.query.data.Queryable;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 0:37
 */
public interface ICommonService<T> extends IService<T> {

    Page<T> list(Queryable queryable);

    Page<T> list(Queryable queryable, Wrapper<T> wrapper);

    List<T> listWithNoPage(Queryable queryable);

    List<T> listWithNoPage(Queryable queryable, Wrapper<T> wrapper);

    Boolean doValid(DuplicateValid duplicateValid, Wrapper<T> wrapper);
}