package com.supermarket.yun.platform.slowloris.service.system;

import com.supermarket.yun.platform.slowloris.domain.system.Attachment;
import com.supermarket.yun.platform.slowloris.service.common.ICommonService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:12
 */
public interface IAttachmentService extends ICommonService<Attachment> {
    /**
     * @param request
     * @param file
     * @return
     * @title: upload
     * @description: 文件上传
     * @return: Attachment
     */
    public Attachment upload(HttpServletRequest request, MultipartFile file) throws Exception;
}
