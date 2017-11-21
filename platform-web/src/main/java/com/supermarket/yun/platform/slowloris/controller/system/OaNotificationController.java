package com.supermarket.yun.platform.slowloris.controller.system;


import com.supermarket.yun.platform.slowloris.controller.common.BaseCRUDController;
import com.supermarket.yun.platform.slowloris.domain.system.OaNotification;
import com.supermarket.yun.platform.slowloris.service.security.annotation.RequiresPathPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通知公告
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:46
 */
@Controller
@RequestMapping("${admin.url.prefix}/oa/oanotification")
@RequiresPathPermission("oa:oanotification")
public class OaNotificationController extends BaseCRUDController<OaNotification, String> {

}
