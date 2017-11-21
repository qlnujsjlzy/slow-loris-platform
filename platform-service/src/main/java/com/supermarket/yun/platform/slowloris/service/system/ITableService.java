package com.supermarket.yun.platform.slowloris.service.system;

import com.supermarket.yun.platform.slowloris.common.exception.GenerationException;
import com.supermarket.yun.platform.slowloris.domain.common.DbTableInfo;
import com.supermarket.yun.platform.slowloris.domain.system.Menu;
import com.supermarket.yun.platform.slowloris.domain.system.Table;
import com.supermarket.yun.platform.slowloris.service.common.ICommonService;
import com.supermarket.yun.platform.slowloris.service.domain.GeneratorInfo;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:14
 */
public interface ITableService extends ICommonService<Table> {

    /**
     * 获得表列表
     *
     * @return
     */
    public List<DbTableInfo> getTableNameList();

    /**
     * 代码生成
     *
     * @title: doGenerateCode
     * @description:代码生成
     * @return: void
     */
    public void generateCode(Table table, GeneratorInfo generatorInfo) throws IOException, GenerationException;

    /**
     * 代码生成
     *
     * @title: doGenerateCode
     * @description:代码生成
     * @return: void
     */
    public void createMenu(Table table, Menu menu);

    /**
     * 代码生成
     *
     * @title: doGenerateCode
     * @description:代码生成
     * @return: void
     */
    public void importDatabase(Table table);

    public void dropTable(String tableid);

    /**
     * 数据库生成
     *
     * @title: syncDatabase
     * @description:数据库生成
     * @return: void
     */
    public void syncDatabase(String tableid) throws TemplateException, IOException;

    public void removeById(Serializable id);

    public List<Table> findSubTable(String tablename);
}
