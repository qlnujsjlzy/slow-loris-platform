package com.supermarket.yun.platform.slowloris.domain.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.supermarket.yun.platform.slowloris.domain.common.DataEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成的字段信息
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:59
 */
@TableName("codegen_table")

public class Table extends DataEntity<String> implements java.io.Serializable {

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    @TableField("title")
    private String title;
    @TableField("table_name")
    private String tableName;
    @TableField("class_name")
    private String className;
    @TableField("table_type")
    private String tableType;
    @TableField("table_pk_type")
    private String tablePKType;
    @TableField("sync_database")
    private Boolean syncDatabase;
    @TableField(exist = false)
    private String parentField;

    @TableField(exist = false)
    private List<Column> columns = new ArrayList<Column>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 实体名称
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public String getTablePKType() {
        return tablePKType;
    }

    public void setTablePKType(String tablePKType) {
        this.tablePKType = tablePKType;
    }

    public Boolean getSyncDatabase() {
        return syncDatabase;
    }

    public void setSyncDatabase(Boolean syncDatabase) {
        this.syncDatabase = syncDatabase;
    }

    public String getParentField() {
        return parentField;
    }

    public void setParentField(String parentField) {
        this.parentField = parentField;
    }

}
