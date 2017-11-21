package com.supermarket.yun.platform.slowloris.common.utils;


import com.supermarket.yun.platform.slowloris.common.query.mapper.JaxbMapper;
import com.supermarket.yun.platform.slowloris.common.xml.definition.Definition;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:37
 */
public class DefinitionUtils {
    public static DefinitionUtils definitionUtils = null;
    public Definition definition = null;

    public DefinitionUtils() {
        String dbType = CodeGenUtils.getDbType().toLowerCase();
        definition = JaxbMapper.fromLocation("codegen/mapper/" + dbType + "_definition.xml", Definition.class);
    }

    public static DefinitionUtils getDefinitionUtils() {
        if (definitionUtils == null) {
            definitionUtils = new DefinitionUtils();
        }
        return definitionUtils;
    }

    public Definition getDefinition() {
        return definition;
    }
}
