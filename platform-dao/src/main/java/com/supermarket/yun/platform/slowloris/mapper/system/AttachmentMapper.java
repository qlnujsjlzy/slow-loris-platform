package com.supermarket.yun.platform.slowloris.mapper.system;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.supermarket.yun.platform.slowloris.domain.system.Attachment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 附件数据库接口
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:49
 */
public interface AttachmentMapper extends BaseMapper<Attachment> {

    /**
     * 获取附件
     *
     * @param page
     * @param wrapper
     * @return
     */
    List<Attachment> selectAttachmentPage(Page<Attachment> page, @Param("ew") Wrapper<Attachment> wrapper);
}