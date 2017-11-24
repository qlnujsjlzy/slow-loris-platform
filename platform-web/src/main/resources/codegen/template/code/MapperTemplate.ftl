package ${packageName}<#if moduleName?exists>.mapper<#if moduleName!=''>.${moduleName}</#if></#if>;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import ${packageName}<#if moduleName?exists>.domain<#if moduleName!=''>.${moduleName}</#if></#if>.${entityName?cap_first};

/**
* @Title: ${functionName}数据库控制层接口
* @Description: ${functionDesc}数据库控制层接口
* @author ${functionAuthor}
* @date ${time}
* @version V1.0
*
*/
public interface ${entityName?cap_first}Mapper extends BaseMapper<${entityName?cap_first}> {

}