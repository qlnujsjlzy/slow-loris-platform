package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.supermarket.yun.platform.slowloris.common.exception.FileNameLengthLimitExceededException;
import com.supermarket.yun.platform.slowloris.common.exception.InvalidExtensionException;
import com.supermarket.yun.platform.slowloris.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.common.utils.*;
import com.supermarket.yun.platform.slowloris.domain.system.Attachment;
import com.supermarket.yun.platform.slowloris.mapper.system.AttachmentMapper;
import com.supermarket.yun.platform.slowloris.service.system.IAttachmentService;
import com.supermarket.yun.platform.slowloris.service.utils.UserUtils;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:10
 */
@Transactional
@Service("attachmentService")
public class AttachmentServiceImpl extends CommonServiceImpl<AttachmentMapper, Attachment> implements IAttachmentService {

    public static final String DEFAULT_CONFIG_FILE = "upload.properties";
    protected String configname = DEFAULT_CONFIG_FILE;
    private long maxSize = 0;
    private boolean needDatePathAndRandomName = true;
    private String[] allowedExtension;
    private String baseDir;

    @Override
    public Page<Attachment> selectPage(Page<Attachment> page, Wrapper<Attachment> wrapper) {
        Page<Attachment> pageInfo = new Page<Attachment>();
        wrapper.eq("1", "1");
        int total = baseMapper.selectCount(wrapper);
        List<Attachment> records = baseMapper.selectAttachmentPage(page, wrapper);
        pageInfo.setTotal(total);
        pageInfo.setRecords(records);
        return pageInfo;
    }

    @PostConstruct
    public void initAttachement() {
        PropertiesUtil propertiesUtil = new PropertiesUtil(configname);
        maxSize = propertiesUtil.getLong("upload.max.size");
        baseDir = propertiesUtil.getString("upload.base.dir");
        String extension = propertiesUtil.getString("upload.allowed.extension");
        allowedExtension = extension.split(",");
    }

    @Override
    public Attachment upload(HttpServletRequest request, MultipartFile file) throws FileUploadBase.FileSizeLimitExceededException,
            InvalidExtensionException, FileNameLengthLimitExceededException, IOException {
        String url = FileUploadUtils.upload(request, baseDir, file, allowedExtension, maxSize,
                needDatePathAndRandomName);
        String filename = file.getOriginalFilename();
        long size = file.getSize();
        String realFileName = StringUtils.getFileNameNoEx(filename);
        String fileext = StringUtils.getExtensionName(filename);
        // 保存上传的信息
        Attachment attachment = new Attachment();
        attachment.setFileext(fileext);
        attachment.setFilename(realFileName);
        attachment.setFilepath(url);
        attachment.setFilesize(size);
        attachment.setStatus("1");
        attachment.setUploadip(IpUtils.getIpAddr(request));
        attachment.setUploadtime(new Date());
        attachment.setUser(UserUtils.getUser());
        insert(attachment);
        return attachment;
    }

    @Override
    public boolean deleteBatchIds(List<? extends Serializable> idList) {
        for(Object object : idList) {
            deleteById((Serializable) object);
        }
        return true;
    }

    @Override
    public boolean deleteById(Serializable id) {
        Attachment attachment = selectById(id);
        String basePath = ServletUtils.getRequest().getServletContext().getRealPath("/");
        String filePath = attachment.getFilepath();
        FileUtil.delFile(basePath + filePath);
        return super.deleteById(id);
    }

}
