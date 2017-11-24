package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.alibaba.fastjson.JSONObject;
import com.supermarket.yun.platform.slowloris.common.exception.GenerationException;
import com.supermarket.yun.platform.slowloris.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.common.utils.CodeGenUtils;
import com.supermarket.yun.platform.slowloris.common.utils.ServletUtils;
import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;
import com.supermarket.yun.platform.slowloris.dao.system.IGeneratorDao;
import com.supermarket.yun.platform.slowloris.domain.AttributeInfo;
import com.supermarket.yun.platform.slowloris.domain.GeneratorInfo;
import com.supermarket.yun.platform.slowloris.domain.common.DbColumnInfo;
import com.supermarket.yun.platform.slowloris.domain.common.DbTableInfo;
import com.supermarket.yun.platform.slowloris.domain.system.Column;
import com.supermarket.yun.platform.slowloris.domain.system.Menu;
import com.supermarket.yun.platform.slowloris.domain.system.Table;
import com.supermarket.yun.platform.slowloris.generator.GeneratorManager;
import com.supermarket.yun.platform.slowloris.mapper.system.TableMapper;
import com.supermarket.yun.platform.slowloris.service.system.IColumnService;
import com.supermarket.yun.platform.slowloris.service.system.IMenuService;
import com.supermarket.yun.platform.slowloris.service.system.ITableService;
import freemarker.template.TemplateException;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:11
 */
@Transactional
@Service("tableService")
public class TableServiceImpl extends CommonServiceImpl<TableMapper, Table> implements ITableService {
    @Autowired
    private IGeneratorDao generatorDao;

    @Autowired
    private IColumnService columnService;

    private GeneratorManager generatorManagor;

    private IMenuService menuService;

    @PostConstruct
    public void initTable() {
        generatorManagor = new GeneratorManager();
    }

    @Override
    public List<DbTableInfo> getTableNameList() {
        return generatorDao.getDbTables();
    }

    @Override
    public boolean insert(Table table) {
        table.setSyncDatabase(Boolean.FALSE);
        String dbType = CodeGenUtils.getDbType();
        if (dbType.equals("oracle")) {
            table.setTableName(table.getTableName().toUpperCase());
        } else {
            table.setTableName(table.getTableName().toLowerCase());
        }
        // 保存主表
        super.insert(table);
        // 字段
        String columnListStr = StringEscapeUtils.unescapeHtml4(ServletUtils.getRequest().getParameter("columnList"));
        List<Column> columnList = JSONObject.parseArray(columnListStr, Column.class);
        for(int i = 0; i < columnList.size(); i++) {
            // 保存字段列表
            Column column = columnList.get(i);
            column.setId("");
            column.setSort(i);
            if (dbType.equals("oracle")) {
                column.setTypeName(column.getTypeName().toUpperCase());
            } else {
                column.setTypeName(column.getTypeName().toLowerCase());
            }
            column.setTable(table);
            columnService.insert(column);
        }
        return true;
    }

    @Override
    public boolean insertOrUpdate(Table table) {
        // 删除已经删除的数据
        List<Column> oldColumnList = columnService.selectListByTableId(table.getId());
        // 字段
        String columnListStr = StringEscapeUtils.unescapeHtml4(ServletUtils.getRequest().getParameter("columnList"));
        List<Column> columnList = JSONObject.parseArray(columnListStr, Column.class);
        String dbType = CodeGenUtils.getDbType();
        if (dbType.equals("oracle")) {
            table.setTableName(table.getTableName().toUpperCase());
        } else {
            table.setTableName(table.getTableName().toLowerCase());
        }
        // 更新主表
        super.insertOrUpdate(table);
        columnList = JSONObject.parseArray(columnListStr, Column.class);
        List<String> newsIdList = new ArrayList<String>();
        int sort = 1;
        // 保存或更新数据
        for(Column column : columnList) {
            column.setSort(sort);
            if (dbType.equals("oracle")) {
                column.setTypeName(column.getTypeName().toUpperCase());
            } else {
                column.setTypeName(column.getTypeName().toLowerCase());
            }
            // 保存字段列表
            if (StringUtils.isEmpty(column.getId()) || column.getId().contains("templateid")) {
                // 保存字段列表
                column.setId("");
                column.setTable(table);
                columnService.insert(column);
            } else {
                // 设置不变更的字段
                columnService.insertOrUpdate(column);
            }
            sort++;
            newsIdList.add(column.getId());
        }

        // 删除老数据
        for(Column column : oldColumnList) {
            String columnId = column.getId();
            if (!newsIdList.contains(columnId)) {
                columnService.deleteById(columnId);
            }
        }
        return true;
    }

    @Override
    public boolean deleteBatchIds(List<? extends Serializable> idList) {
        for(Serializable id : idList) {
            deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteById(Serializable id) {
        // 删除已经删除的数据
        Table table = selectById(id);
        // 先刪除表
        try {
            generatorDao.dropTable(table.getTableName());
        } catch(Exception e) {
            e.printStackTrace();
            // 部分数据库在没有表而执行删表语句时会报错
            // logger.error(e.getMessage());
        }
        removeById(id);
        return true;
    }

    @Override
    public void removeById(Serializable id) {
        // 删除已经删除的数据
        List<Column> columnList = columnService.selectListByTableId((String) id);
        // 保存或更新数据
        for(Column column : columnList) {
            columnService.deleteById(column.getId());
        }
        super.deleteById(id);
    }

    @Override
    public void generateCode(Table table, GeneratorInfo generatorInfo) throws IOException, GenerationException {
        generatorInfo.setTableName(table.getTableName());
        table.setClassName(generatorInfo.getEntityName());
        List<Column> columnList = columnService.selectListByTableId(table.getId());
        List<AttributeInfo> attributeInfos = new ArrayList<AttributeInfo>();
        for(Column column : columnList) {
            attributeInfos.add(new AttributeInfo(column));
        }
        generatorInfo.setType(table.getTableType());
        generatorInfo.setColumns(columnList);
        generatorInfo.setAttributeInfos(attributeInfos);
        // 查询附表
        List<Table> schedules = null;
        if (table.getTableType().equals("2")) {
            // 获得附表
            schedules = findSubTable(table.getTableName());
            for(Table tableEntity : schedules) {
                List<Column> subColumnList = columnService.selectListByTableId(tableEntity.getId());
                tableEntity.setColumns(subColumnList);
                for(Column column : subColumnList) {
                    if (!StringUtils.isEmpty(column.getForeignTable())
                            && column.getForeignTable().equals(table.getTableName())) {
                        tableEntity.setParentField(column.getJavaField());
                    }
                }
            }
            generatorInfo.setSchedules(schedules);
            // 生成附表实体
        }
        generatorManagor.process(generatorInfo);
        // 查询附表
        if (table.getTableType().equals("2")) {
            for(Table tableEntity : schedules) {
                generatorInfo.setTableName(tableEntity.getTableName());
                generatorInfo.setFunctionDesc(tableEntity.getRemarks());
                generatorInfo.setEntityName(tableEntity.getClassName());
                generatorInfo.setFunctionName(tableEntity.getRemarks());
                List<Column> subColumnList = tableEntity.getColumns();
                List<AttributeInfo> subAttributeInfos = new ArrayList<AttributeInfo>();
                for(Column column : subColumnList) {
                    if (!StringUtils.isEmpty(column.getForeignTable())
                            && column.getForeignTable().equals(table.getTableName())) {
                        column.setJavaType(table.getClassName());
                        tableEntity.setParentField(column.getJavaField());
                        column.setImportedKey(Boolean.TRUE);
                    }
                    AttributeInfo attributeInfo = new AttributeInfo(column);
                    subAttributeInfos.add(attributeInfo);
                }
                generatorInfo.setType(tableEntity.getTableType());
                generatorInfo.setColumns(subColumnList);
                generatorInfo.setAttributeInfos(subAttributeInfos);
                List<String> generatorKeys = new ArrayList<String>();
                generatorKeys.add("Entity");
                generatorKeys.add("IService");
                generatorKeys.add("ServiceImpl");
                generatorKeys.add("Mapper");
                generatorKeys.add("xmlMapper");
                generatorInfo.setGeneratorKeys(generatorKeys);
                generatorManagor.process(generatorInfo);
            }
        }
    }

    @Override
    public void importDatabase(Table table) {
        String tableName = table.getTableName();
        String title = tableName;
        if (tableName.contains(":")) {
            String[] tableInfos = tableName.split(":");
            tableName = tableInfos[0];
            title = tableInfos[1];
        }
        table.setTitle(title);
        table.setRemarks(title);
        table.setTableName(tableName);
        table.setSyncDatabase(Boolean.TRUE);
        // 保存主表
        super.insert(table);
        List<DbColumnInfo> dbColumnInfos = generatorDao.getDbColumnInfo(tableName);
        for(int j = 0; j < dbColumnInfos.size(); j++) {
            Column column = new Column(dbColumnInfos.get(j));
            column.setSort(j + 1);
            // 保存字段列表
            column.setTable(table);
            columnService.insert(column);
        }

    }

    public void dropTable(String tableid) {
        Table table = selectById(tableid);
        try {
            generatorDao.dropTable(table.getTableName());
        } catch(Exception e) {
            // 部分数据库在没有表而执行删表语句时会报错
            // logger.error(e.getMessage());
        }
    }

    @Override
    public void syncDatabase(String tableid) throws TemplateException, IOException {
        Table table = selectById(tableid);
        List<Column> columns = columnService.selectListByTableId(table.getId());
        table.setColumns(columns);
        String dbType = CodeGenUtils.getDbType();
        Map<String, Object> tableInfo = new HashMap<String, Object>();
        tableInfo.put("table", table);
        tableInfo.put("dbType", dbType);
        generatorDao.createTable(tableInfo);
        table.setSyncDatabase(Boolean.TRUE);
        super.insertOrUpdate(table);
    }

    @Override
    public void createMenu(Table table, Menu menu) {
        String url = "";
        String permission = "";
        menu.setIsshow((short) 1);
        menu.setUrl(url);
        menu.setPermission(permission);
        menu.setRemarks(table.getRemarks());
        menuService.insert(menu);
    }

    @Override
    public List<Table> findSubTable(String tablename) {
        return baseMapper.findSubTables(tablename);
    }

}
