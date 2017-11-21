package com.supermarket.yun.platform.slowloris.controller.system;

import com.supermarket.yun.platform.slowloris.common.domain.AjaxJson;
import com.supermarket.yun.platform.slowloris.controller.common.BaseCRUDController;
import com.supermarket.yun.platform.slowloris.controller.common.SysDatabaseEnum;
import com.supermarket.yun.platform.slowloris.domain.system.DataSource;
import com.supermarket.yun.platform.slowloris.service.security.annotation.RequiresPathPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:45
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/datasource")
@RequiresPathPermission("sys:datasource")
public class DataSourceController extends BaseCRUDController<DataSource, String> {

    @RequestMapping(value = "dataSourceParameter")
    @ResponseBody
    public AjaxJson dataSourceParameter(@RequestParam String dbType) {
        AjaxJson j = new AjaxJson();
        SysDatabaseEnum sysDatabaseEnum = SysDatabaseEnum.toEnum(dbType);

        if (sysDatabaseEnum != null) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("driverClass", sysDatabaseEnum.getDriverClass());
            map.put("url", sysDatabaseEnum.getUrl());
            map.put("dbtype", sysDatabaseEnum.getDbtype());
            j.setData(map);
        } else {
            j.setData(null);
        }
        return j;
    }
}
