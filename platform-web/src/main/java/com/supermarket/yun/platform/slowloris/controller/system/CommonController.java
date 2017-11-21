package com.supermarket.yun.platform.slowloris.controller.system;

import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;
import com.supermarket.yun.platform.slowloris.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 公用控制器
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:45
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/common")
public class CommonController extends BaseController {

    /**
     * 图表资源
     *
     * @return
     */
    @RequestMapping(value = "icons", method = RequestMethod.GET)
    public String list(Model model) {
        return display("icons");
    }

    @RequestMapping(value = "treeselect", method = RequestMethod.GET)
    public String treeselect(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getParameter("url")); // 树结构数据URL
        String multiselect = request.getParameter("multiselect");
        String chkboxType = request.getParameter("chkboxType");
        model.addAttribute("chkboxType", chkboxType); // 父子关联
        if (StringUtils.isEmpty(multiselect)) {
            multiselect = Boolean.TRUE + "";
        }
        model.addAttribute("multiselect", multiselect); // 是否多选
        String selectNodes = request.getParameter("selectNodes");
        model.addAttribute("selectNodes", selectNodes);// 默认值
        return display("treeselect");
    }
}
