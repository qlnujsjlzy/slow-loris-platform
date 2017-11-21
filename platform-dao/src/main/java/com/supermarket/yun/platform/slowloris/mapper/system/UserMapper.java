package com.supermarket.yun.platform.slowloris.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.supermarket.yun.platform.slowloris.domain.system.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:50
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * @param wrapper
     * @title: selectUserList
     * @description: 查找用户列表
     * @return: List<User>
     */
    List<User> selectUserList(Pagination page, @Param("ew") Wrapper<User> wrapper);
}