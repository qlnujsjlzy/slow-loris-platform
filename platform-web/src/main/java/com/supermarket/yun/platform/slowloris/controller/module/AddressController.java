package com.supermarket.yun.platform.slowloris.controller.module;

import com.supermarket.yun.platform.slowloris.common.BaseCRUDController;
import com.supermarket.yun.platform.slowloris.domain.module.Address;
import com.supermarket.yun.platform.slowloris.security.annotation.RequiresPathPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author licy13
 * @version V1.0
 * @Title: address
 * @Description: 收货地址
 * @date 2017-11-24 23:27:37
 */
@Controller
@RequestMapping("${admin.url.prefix}/module/address")
@RequiresPathPermission("module:address")
public class AddressController extends BaseCRUDController<Address, Integer> {

}
