package com.supermarket.yun.platform.slowloris.controller.system;

import com.supermarket.yun.platform.slowloris.common.domain.AjaxJson;
import com.supermarket.yun.platform.slowloris.controller.common.BaseCRUDController;
import com.supermarket.yun.platform.slowloris.domain.system.DictGroup;
import com.supermarket.yun.platform.slowloris.service.security.annotation.RequiresPathPermission;
import com.supermarket.yun.platform.slowloris.service.utils.DictUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:47
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/dict/group")
@RequiresPathPermission("sys:dict")
public class DictGroupController extends BaseCRUDController<DictGroup, String> {

    @RequestMapping(value = "/forceRefresh", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson forceRefresh(HttpServletRequest request, HttpServletResponse response) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("字典刷新成功");
        try {
            DictUtils.clear();
        } catch(Exception e) {
            e.printStackTrace();
            ajaxJson.fail("字典刷新失败" + e.getMessage());
        }
        return ajaxJson;
    }
}
