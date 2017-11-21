package com.supermarket.yun.platform.slowloris.common.base;

/**
 * 树节点 公共接口方法
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 21:01
 */
public interface TreeNode<ID> {

    public ID getId();// 主键

    public void setId(ID name);// 设置主键

    public Boolean isRoot();//是否是根节点

    public String getName();// 节点名称

    public void setName(String name);// 设置节点名称

    public Long getLevel();// 节点的级别，默认最高级为0

    public Boolean isLeaf();// 是否为叶节点，为true时表示该节点下面没有子节点了

    public String getSeparator();//获取 parentIds 之间的分隔符

    public String makeSelfAsNewParentIds(); //把自己构造出新的父节点路径

    public ID getParentId();//父路径

    public void setParentId(ID parentId);

    public String getParentIds();//所有父路径 如1,2,3,

    public void setParentIds(String parentIds);

    public Boolean getExpanded();// 是否默认展开状态

    public void setExpanded(Boolean expanded);// 是否默认展开状态

    public Boolean getLoaded();// 是否已经加载过子节点（为false时点击节点会自动加载子节点）

    public void setLoaded(Boolean loaded);// 是否已经加载过子节点（为false时点击节点会自动加载子节点）

}
