package com.supermarket.yun.platform.slowloris.service.generator;


import com.supermarket.yun.platform.slowloris.common.exception.GenerationException;
import com.supermarket.yun.platform.slowloris.service.domain.GeneratorInfo;

import java.io.IOException;
import java.util.Map;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:04
 */
public interface IGenerator {
    void generate(GeneratorInfo generatorInfo, Map<String, Object> dataMap) throws IOException,
            GenerationException;
}
