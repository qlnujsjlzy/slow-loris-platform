package com.supermarket.yun.platform.slowloris.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.supermarket.yun.platform.slowloris.domain.system.UserOnline;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:50
 */
public interface UserOnlineMapper extends BaseMapper<UserOnline> {

    /**
     * 获取在线用户的列表
     *
     * @param page
     * @param wrapper
     * @return
     */
    List<UserOnline> selectUserOnlinePage(Page<UserOnline> page, @Param("ew") Wrapper<UserOnline> wrapper);
}