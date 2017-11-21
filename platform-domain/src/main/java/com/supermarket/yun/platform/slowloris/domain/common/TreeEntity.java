package com.supermarket.yun.platform.slowloris.domain.common;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import com.supermarket.yun.platform.slowloris.common.base.TreeNode;
import com.supermarket.yun.platform.slowloris.common.domain.AbstractEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 树抽象实体基类
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 20:57
 */
public abstract class TreeEntity<T> extends AbstractEntity<String> implements TreeNode<String> {

    @TableId(value = "id", type = IdType.UUID)
    private String id; // 编号

    @TableField(value = "name")
    private String name; // 资源名称

    @TableField(value = "parent_id", strategy = FieldStrategy.IGNORED)
    private String parentId; // 父编号

    @TableField(value = "parent_ids", strategy = FieldStrategy.IGNORED)
    private String parentIds; // 父编号列表

    @TableField(exist = false)
    private Boolean expanded = Boolean.FALSE;

    @TableField(exist = false)
    private Boolean loaded = Boolean.TRUE;

    @TableField(exist = false)
    private T parent;

    @TableField(exist = false)
    private boolean hasChildren; //是否有叶子节点


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Override
    public Boolean isRoot() {
        if (getParentId() == null || getParentId().equals("0") || getParentId().equals("")) {
            return true;
        }
        return false;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    @Override
    public Long getLevel() {
        if (parentIds == null) {
            return (long) 0;
        }
        String[] parentIdArr = parentIds.split("/");
        List<String> idsList = new ArrayList<String>();
        for(String id : parentIdArr) {
            if (!StringUtils.isEmpty(id)) {
                idsList.add(id);
            }
        }
        return (long) (idsList.size());
    }

    @Override
    public Boolean isLeaf() {
        if (isHasChildren()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public String makeSelfAsNewParentIds() {
        if (StringUtils.isEmpty(getParentIds())) {
            return getId() + getSeparator();
        }
        return getParentIds() + getId() + getSeparator();
    }

    @Override
    public String getSeparator() {
        return "/";
    }

    @Override
    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public Boolean getLoaded() {
        return loaded;
    }

    @Override
    public void setLoaded(Boolean loaded) {
        this.loaded = loaded;
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }
}
