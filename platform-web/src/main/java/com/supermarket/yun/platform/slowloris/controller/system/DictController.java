package com.supermarket.yun.platform.slowloris.controller.system;

import com.supermarket.yun.platform.slowloris.common.query.data.QueryRequest;
import com.supermarket.yun.platform.slowloris.common.query.wrapper.EntityWrapper;
import com.supermarket.yun.platform.slowloris.controller.common.BaseCRUDController;
import com.supermarket.yun.platform.slowloris.domain.system.Dict;
import com.supermarket.yun.platform.slowloris.domain.system.DictGroup;
import com.supermarket.yun.platform.slowloris.service.security.annotation.RequiresPathPermission;
import com.supermarket.yun.platform.slowloris.service.system.IDictGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:47
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/dict")
@RequiresPathPermission("sys:user")
public class DictController extends BaseCRUDController<Dict, String> {
    @Autowired
    private IDictGroupService dictGroupService;

    @Override
    public void preList(Model model, HttpServletRequest request, HttpServletResponse response) {
        String gid = request.getParameter("gid");
        DictGroup group = dictGroupService.selectById(gid);
        model.addAttribute("group", group);
    }

    @Override
    public void preAjaxList(QueryRequest queryable, EntityWrapper<Dict> entityWrapper, HttpServletRequest request,
                            HttpServletResponse response) {
        String gid = request.getParameter("gid");
        queryable.addCondition("gid", gid);
    }

    @Override
    public void preEdit(Dict entity, Model model, HttpServletRequest request, HttpServletResponse response) {
        String gid = request.getParameter("gid");
        model.addAttribute("gid", gid);
    }
}
