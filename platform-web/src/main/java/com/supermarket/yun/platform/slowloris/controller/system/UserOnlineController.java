package com.supermarket.yun.platform.slowloris.controller.system;

import com.alibaba.fastjson.JSON;
import com.supermarket.yun.platform.slowloris.common.BaseController;
import com.supermarket.yun.platform.slowloris.common.domain.AjaxJson;
import com.supermarket.yun.platform.slowloris.common.domain.OnlineSession;
import com.supermarket.yun.platform.slowloris.common.query.annotation.PageableDefaults;
import com.supermarket.yun.platform.slowloris.common.query.data.Page;
import com.supermarket.yun.platform.slowloris.common.query.data.PageImpl;
import com.supermarket.yun.platform.slowloris.common.query.data.QueryPropertyPreFilter;
import com.supermarket.yun.platform.slowloris.common.query.data.QueryRequest;
import com.supermarket.yun.platform.slowloris.common.utils.LorisPropertiesUtil;
import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;
import com.supermarket.yun.platform.slowloris.domain.system.UserOnline;
import com.supermarket.yun.platform.slowloris.security.annotation.RequiresMethodPermissions;
import com.supermarket.yun.platform.slowloris.security.annotation.RequiresPathPermission;
import com.supermarket.yun.platform.slowloris.security.session.SessionDAO;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:50
 */
@Controller
@RequestMapping(value = "${admin.url.prefix}/sys/online")
@RequiresPathPermission("sys:online")
public class UserOnlineController extends BaseController {

    @Autowired
    private SessionDAO sessionDAO;

    public UserOnlineController() {
    }


    @RequiresMethodPermissions("list")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        // 预处理
        Collection<Session> sessionList = sessionDAO.getActiveSessions(false, null, null);
        List<UserOnline> onlineSessionList = new ArrayList<UserOnline>();
        for(Session session : sessionList) {
            UserOnline userOnline = UserOnline.fromOnlineSession((OnlineSession) session);
            if (!StringUtils.isEmpty(userOnline.getUserId())) {
                onlineSessionList.add(UserOnline.fromOnlineSession((OnlineSession) session));
            }
        }
        model.addAttribute("onlineSessionList", onlineSessionList);
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
    @PageableDefaults(sort = "id=desc")
    private void ajaxList(QueryRequest queryable, QueryPropertyPreFilter propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        // 预处理
        Collection<Session> onlineSessionList = sessionDAO.getActiveSessions(true, null, null);
        Page<Session> onlineSessionPage = new PageImpl<Session>((List<Session>) onlineSessionList);
        String content = JSON.toJSONString(onlineSessionPage);
        StringUtils.printJson(response, content);
    }

    @RequestMapping("/forceLogout")
    @ResponseBody
    public AjaxJson forceLogout(@RequestParam(value = "ids") String[] ids) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setMsg("强制退出成功");
        if (LorisPropertiesUtil.getProperties().getBoolean("demoMode")) {
            ajaxJson.fail("演示模式，不允许强制退出用户！");
            return ajaxJson;
        }
        for(String id : ids) {
            OnlineSession onlineSession = (OnlineSession) sessionDAO.readSession(id);
            if (onlineSession == null) {
                continue;
            }
            onlineSession.setStatus(OnlineSession.OnlineStatus.force_logout);
            //sessionDAO.update(onlineSession);
        }
        return ajaxJson;
    }

}
