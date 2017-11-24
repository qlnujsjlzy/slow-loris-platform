package com.supermarket.yun.platform.slowloris.controller.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.supermarket.yun.platform.slowloris.common.BaseController;
import com.supermarket.yun.platform.slowloris.common.domain.AjaxJson;
import com.supermarket.yun.platform.slowloris.common.domain.PageJson;
import com.supermarket.yun.platform.slowloris.common.exception.FileNameLengthLimitExceededException;
import com.supermarket.yun.platform.slowloris.common.exception.InvalidExtensionException;
import com.supermarket.yun.platform.slowloris.common.query.data.QueryPropertyPreFilter;
import com.supermarket.yun.platform.slowloris.common.query.data.QueryRequest;
import com.supermarket.yun.platform.slowloris.common.query.utils.QueryableConvertUtils;
import com.supermarket.yun.platform.slowloris.common.query.wrapper.EntityWrapper;
import com.supermarket.yun.platform.slowloris.common.utils.MessageUtils;
import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;
import com.supermarket.yun.platform.slowloris.domain.system.Attachment;
import com.supermarket.yun.platform.slowloris.security.annotation.RequiresMethodPermissions;
import com.supermarket.yun.platform.slowloris.security.annotation.RequiresPathPermission;
import com.supermarket.yun.platform.slowloris.service.system.IAttachmentService;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 23:45
 */

@Controller
@RequestMapping("${admin.url.prefix}/sys/attachment")
@RequiresPathPermission("sys:attachment")
public class AttachmentController extends BaseController {

    @Autowired
    private IAttachmentService attachmentService;

    @RequiresMethodPermissions("list")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        return display("list");
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "ajaxList", method = {RequestMethod.GET, RequestMethod.POST})
    private void ajaxList(QueryRequest queryable, QueryPropertyPreFilter propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, Attachment.class);
        SerializeFilter filter = propertyPreFilterable.constructFilter(Attachment.class);
        PageJson<Attachment> pagejson = new PageJson<Attachment>(attachmentService.list(queryable));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response, content);
    }

    /**
     * @param request
     * @param response
     * @return
     * @title: ajaxUpload
     * @description: 文件上传
     * @return: AjaxUploadResponse
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson upload(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        AjaxJson ajaxJson = new AjaxJson();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();
            while(ite.hasNext()) {
                MultipartFile file = multiRequest.getFile(ite.next());
                try {
                    Attachment attachment = attachmentService.upload(request, file);
                    attachmentList.add(attachment);
                    continue;
                } catch(IOException e) {
                    ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch(InvalidExtensionException e) {
                    ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch(FileUploadBase.FileSizeLimitExceededException e) {
                    ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch(FileNameLengthLimitExceededException e) {
                    ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

            ajaxJson.setData(attachmentList);
        }
        return ajaxJson;
    }

    /**
     * @param request
     * @param response
     * @return
     * @title: ajaxUpload
     * @description: 文件上传
     * @return: AjaxUploadResponse
     */
    @RequestMapping(value = "uploadSimditor", method = RequestMethod.POST)
    @ResponseBody
    public void uploadSimditor(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        AjaxJson ajaxJson = new AjaxJson();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        Map<String, Object> data = new HashMap<String, Object>();
        if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();
            while(ite.hasNext()) {
                MultipartFile file = multiRequest.getFile(ite.next());
                try {
                    Attachment attachment = attachmentService.upload(request, file);
                    attachmentList.add(attachment);
                    continue;
                } catch(IOException e) {
                    ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch(InvalidExtensionException e) {
                    ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch(FileUploadBase.FileSizeLimitExceededException e) {
                    ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch(FileNameLengthLimitExceededException e) {
                    ajaxJson.fail(MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            String ctxPath = request.getContextPath();
            ajaxJson.setData(attachmentList);
            data.put("success", Boolean.TRUE);
            data.put("msg", MessageUtils.getMessage("upload.server.error"));
            data.put("file_path", ctxPath + "/" + attachmentList.get(0).getFilepath());
        } else {
            data.put("success", Boolean.FALSE);
            data.put("msg", MessageUtils.getMessage("upload.server.error"));
        }
        StringUtils.printJson(response, data);
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson delete(@PathVariable("id") String id) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("删除成功");
        try {
            attachmentService.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "batch/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AjaxJson batchDelete(@RequestParam(value = "ids", required = false) String[] ids) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("删除成功");
        try {
            List<String> idList = java.util.Arrays.asList(ids);
            attachmentService.deleteBatchIds(idList);
        } catch(Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    /**
     * @param request
     * @param response
     * @return
     * @title: ajaxUpload
     * @description: 文件上传
     * @return: AjaxUploadResponse
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson list(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        AjaxJson ajaxJson = new AjaxJson();
        String saveType = request.getParameter("saveType");
        if (saveType.equals("id")) {
            String id = request.getParameter("id");
            List<Attachment> list = attachmentService
                    .selectList(new EntityWrapper<Attachment>().in("id", id.split(",")));
            ajaxJson.setData(list);
        } else {
            String filepath = request.getParameter("url");
            List<Attachment> list = attachmentService
                    .selectList(new EntityWrapper<Attachment>().in("filepath", filepath.split(",")));
            ajaxJson.setData(list);
        }

        return ajaxJson;
    }
}
