package com.supermarket.yun.platform.slowloris.service.bill.impl;

import com.supermarket.yun.platform.slowloris.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.domain.bill.Bill;
import com.supermarket.yun.platform.slowloris.mapper.bill.BillMapper;
import com.supermarket.yun.platform.slowloris.service.bill.IBillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @Title: bill
* @Description: 账单
* @author licy13
* @date 2017-11-25 00:15:27
* @version V1.0
*
*/
@Transactional
@Service("billService")
public class BillServiceImpl  extends CommonServiceImpl<BillMapper,Bill> implements  IBillService {

}
