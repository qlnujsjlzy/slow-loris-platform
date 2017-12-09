package com.supermarket.yun.platform.slowloris.controller.bill;


import com.supermarket.yun.platform.slowloris.common.BaseCRUDController;
import com.supermarket.yun.platform.slowloris.domain.bill.Bill;
import com.supermarket.yun.platform.slowloris.security.annotation.RequiresPathPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Title: bill
* @Description: 账单
* @author licy13
* @date 2017-11-25 00:15:27
* @version V1.0
*
*/
@Controller
@RequestMapping("${admin.url.prefix}/bill/bill")
@RequiresPathPermission("bill:bill")
public class BillController extends BaseCRUDController<Bill, Integer> {

}
