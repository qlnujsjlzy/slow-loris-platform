package com.supermarket.yun.platform.slowloris.service.module.impl;

import com.supermarket.yun.platform.slowloris.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.domain.module.Address;
import com.supermarket.yun.platform.slowloris.mapper.module.AddressMapper;
import com.supermarket.yun.platform.slowloris.service.module.IAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @Title: address
* @Description: 收货地址
* @author licy13
* @date 2017-11-24 23:27:37
* @version V1.0
*
*/
@Transactional
@Service("addressService")
public class AddressServiceImpl  extends CommonServiceImpl<AddressMapper,Address> implements  IAddressService {

}
