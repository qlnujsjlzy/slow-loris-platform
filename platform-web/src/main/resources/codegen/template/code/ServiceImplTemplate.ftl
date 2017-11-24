package ${packageName}<#if moduleName?exists>.service<#if moduleName!=''>.${moduleName}</#if></#if>.impl;

import com.supermarket.yun.platform.slowloris.service.common.impl.CommonServiceImpl;
import ${packageName}<#if moduleName?exists>.mapper<#if moduleName!=''>.${moduleName}</#if></#if>.${entityName?cap_first}Mapper;
import ${packageName}<#if moduleName?exists>.domain<#if moduleName!=''>.${moduleName}</#if></#if>.${entityName?cap_first};
import ${packageName}<#if moduleName?exists>.service<#if moduleName!=''>.${moduleName}</#if></#if>.I${entityName?cap_first}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @Title: ${functionName}
* @Description: ${functionDesc}
* @author ${functionAuthor}
* @date ${time}
* @version V1.0
*
*/
@Transactional
@Service("${entityName?uncap_first}Service")
public class ${entityName?cap_first}ServiceImpl  extends CommonServiceImpl<${entityName?cap_first}Mapper,${entityName?cap_first}> implements  I${entityName?cap_first}Service {

}
