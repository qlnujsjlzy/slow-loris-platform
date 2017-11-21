package com.supermarket.yun.platform.slowloris.common.xml.generator;

import com.supermarket.yun.platform.slowloris.common.query.mapper.JaxbMapper;
import com.supermarket.yun.platform.slowloris.common.query.mapper.JsonMapper;
import com.supermarket.yun.platform.slowloris.common.xml.definition.Definition;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:39
 */
@XmlRootElement(name = "config")
public class ConfigXmlMap implements Serializable {

    List<GeneratorXmlMap> generatorXmpMapList;

    public static void main(String[] args) {
        ConfigXmlMap xmlMap = JaxbMapper.fromLocation("codegen/mapper/code_generator.xml", ConfigXmlMap.class);
        Definition definition = JaxbMapper.fromLocation("codegen/mapper/mysql_definition.xml", Definition.class);

        System.out.println(JsonMapper.toJsonString(xmlMap));
    }

    @XmlElementWrapper(name = "generators")
    @XmlElements({@XmlElement(name = "generator", type = GeneratorXmlMap.class)})
    public List<GeneratorXmlMap> getGeneratorXmpMapList() {
        return generatorXmpMapList;
    }

    public void setGeneratorXmpMapList(List<GeneratorXmlMap> generatorXmpMapList) {
        this.generatorXmpMapList = generatorXmpMapList;
    }

}
