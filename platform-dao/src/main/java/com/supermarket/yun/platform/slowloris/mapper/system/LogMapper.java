package com.supermarket.yun.platform.slowloris.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.supermarket.yun.platform.slowloris.domain.system.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:49
 */
public interface LogMapper extends BaseMapper<Log> {

    /**
     * 获取log列表
     *
     * @param page
     * @param wrapper
     * @return
     */
    List<Log> selectLogPage(Page<Log> page, @Param("ew") Wrapper<Log> wrapper);
}