package ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.service;

import com.supermarket.yun.platform.slowloris.service.common.ICommonService;
import ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.entity.${entityName?cap_first};

/**
* @Title: ${functionName}
* @Description: ${functionDesc}
* @author ${functionAuthor}
* @date ${time}
* @version V1.0
*
*/
public interface I${entityName?cap_first}Service extends ICommonService<${entityName?cap_first}> {

}

