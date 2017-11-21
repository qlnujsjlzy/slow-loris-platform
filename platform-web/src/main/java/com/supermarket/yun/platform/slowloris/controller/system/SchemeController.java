package com.supermarket.yun.platform.slowloris.controller.system;


import com.supermarket.yun.platform.slowloris.controller.common.BaseCRUDController;
import com.supermarket.yun.platform.slowloris.domain.system.Scheme;
import com.supermarket.yun.platform.slowloris.service.security.annotation.RequiresPathPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 代码生成方案
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:46
 */
@Controller
@RequestMapping("${admin.url.prefix}/codegen/scheme")
@RequiresPathPermission("codegen:scheme")
public class SchemeController extends BaseCRUDController<Scheme, String> {

}
