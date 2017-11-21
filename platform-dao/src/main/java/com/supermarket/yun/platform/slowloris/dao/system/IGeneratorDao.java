package com.supermarket.yun.platform.slowloris.dao.system;

import com.supermarket.yun.platform.slowloris.domain.common.DbColumnInfo;
import com.supermarket.yun.platform.slowloris.domain.common.DbTableInfo;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 使用JdbcTemplate来获取数据库表和列的元数据
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/20 19:04
 */
public interface IGeneratorDao {

    /**
     * 获取所有的表名
     *
     * @return
     */
    public List<DbTableInfo> getDbTables();

    /**
     * 通过表名获取所有的表名
     *
     * @param tableName
     * @return
     */
    public List<DbColumnInfo> getDbColumnInfo(String tableName);

    /**
     * 生成数据库模版
     *
     * @param tableInfo
     * @throws TemplateException
     * @throws IOException
     */
    public void createTable(Map<String, Object> tableInfo) throws TemplateException, IOException;

    /**
     * 判断表名是否存在
     *
     * @param tableName
     * @return
     */
    public Boolean isExistTable(String tableName);

    /**
     * 删除表
     *
     * @param tableName
     */
    public void dropTable(String tableName);

}