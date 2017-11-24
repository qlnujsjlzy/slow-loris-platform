package ${packageName}<#if moduleName?exists>.controller<#if moduleName!=''>.${moduleName}</#if></#if>;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.supermarket.yun.platform.slowloris.controller.common.BaseCRUDController;
import com.supermarket.yun.platform.slowloris.service.security.annotation.RequiresPathPermission;
import ${packageName}<#if moduleName?exists>.domain<#if moduleName!=''>.${moduleName}</#if></#if>.${entityName?cap_first};

/**
* @Title: ${functionName}
* @Description: ${functionDesc}
* @author ${functionAuthor}
* @date ${time}
* @version V1.0
*
*/
@Controller
@RequestMapping("${r'${admin.url.prefix}'}/${moduleName}/${entityName?lower_case}")
@RequiresPathPermission("${moduleName}:${entityName?lower_case}")
public class ${entityName?cap_first}Controller extends BaseCRUDController<${entityName?cap_first}, Integer> {

}
