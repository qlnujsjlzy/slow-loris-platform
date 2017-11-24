package com.supermarket.yun.platform.slowloris.generator;


import com.supermarket.yun.platform.slowloris.common.exception.GenerationException;
import com.supermarket.yun.platform.slowloris.common.query.mapper.JaxbMapper;
import com.supermarket.yun.platform.slowloris.common.utils.MapBeanUtil;
import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;
import com.supermarket.yun.platform.slowloris.common.xml.generator.ConfigXmlMap;
import com.supermarket.yun.platform.slowloris.common.xml.generator.GeneratorXmlMap;
import com.supermarket.yun.platform.slowloris.domain.AttributeInfo;
import com.supermarket.yun.platform.slowloris.domain.GeneratorInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:04
 */
public class GeneratorManager {
    private final static Logger logger = LogManager.getLogger();
    private static GeneratorManager manager = new GeneratorManager();
    private final String GENERATOR_DEFAULT_LOCATION = "codegen/template/code/mapper/code_generator.xml";
    private Map<String, IGenerator> generatorMap = new HashMap<String, IGenerator>();
    private String location = GENERATOR_DEFAULT_LOCATION;

    public GeneratorManager() {
        try {
            initGeneratorByXml(location);
        } catch(Exception e) {
            logger.error("代码生成器配置“" + GENERATOR_DEFAULT_LOCATION + "”加载失败...");
        }
    }

    public static GeneratorManager getManager() {
        if (manager == null) {
            manager = new GeneratorManager();
        }
        return manager;
    }

    public static void main(String[] args) {
        GeneratorManager manager = GeneratorManager.getManager();
        for(Map.Entry<String, IGenerator> map : manager.generatorMap.entrySet()) {
            System.out.println("key:" + map.getKey());
        }
    }

    public void initGeneratorByXml(String location) {
        // 加载配置
        ConfigXmlMap xmlMap = JaxbMapper.fromLocation(location, ConfigXmlMap.class);
        List<GeneratorXmlMap> GeneratorXmpMapList = xmlMap.getGeneratorXmpMapList();
        for(GeneratorXmlMap generatorXmpMap : GeneratorXmpMapList) {
            DefaultGenerator.GeneratorConfig generatorConfig = new DefaultGenerator.GeneratorConfig();
            generatorConfig.setKey(generatorXmpMap.getKey());
            generatorConfig.setCodeType(generatorXmpMap.getCodeType());
            generatorConfig.setLayer(generatorXmpMap.getLayer());
            generatorConfig.setNameFormat(generatorXmpMap.getNameFormat());
            generatorConfig.setTemplateFile(generatorXmpMap.getTemplateFile());
            registerGenerator(generatorConfig);
        }
    }

    /**
     * 注册一个代码生成器
     *
     * @param generatorConfig
     */
    public void registerGenerator(DefaultGenerator.GeneratorConfig generatorConfig) {
        IGenerator codeGenerator = new DefaultGenerator(generatorConfig);
        registerGenerator(generatorConfig.getKey(), codeGenerator);
    }

    /**
     * 注册一个代码生成器
     *
     * @param generator
     */
    public void registerGenerator(String key, IGenerator generator) {
        generatorMap.put(key, generator);
    }

    public void process(GeneratorInfo generatorInfo) throws IOException, GenerationException {
        Map<String, Object> dataMap = getFtlMap(generatorInfo);
        List<String> generatorKeys = generatorInfo.getGeneratorKeys();
        for(String generatorKey : generatorKeys) {
            if (generatorMap.containsKey(generatorKey)) {
                IGenerator codeGenerator = generatorMap.get(generatorKey);
                codeGenerator.generate(generatorInfo, dataMap);
            }
        }
    }

    public Map<String, Object> getFtlMap(GeneratorInfo generatorInfo) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
            List<String> importTypes = new ArrayList<String>();
            List<AttributeInfo> attributeInfos = generatorInfo.getAttributeInfos();
            Map<String, Boolean> tempImportMap = new HashMap<String, Boolean>();
            if (attributeInfos != null) {
                for(AttributeInfo attributeInfo : attributeInfos) {
                    String importType = attributeInfo.getImportType();
                    if (!StringUtils.isEmpty(importType) && !tempImportMap.containsKey(importType)) {
                        importTypes.add(importType);
                        tempImportMap.put(importType, true);
                    }
                }
                generatorInfo.setImportTypes(importTypes);
            }
            dataMap = MapBeanUtil.convertBean(generatorInfo);
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        } catch(InvocationTargetException e) {
            e.printStackTrace();
        } catch(IntrospectionException e) {

            e.printStackTrace();
        }
        return dataMap;
    }
}
