package com.supermarket.yun.platform.slowloris.common.utils;

import com.supermarket.yun.platform.slowloris.common.base.TreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树排序
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:38
 */
public class TreeSortUtil<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 2444638065060902858L;

    private List<TreeNode<ID>> treeNodes;

    private List<TreeNode<ID>> newTreeNodes;

    public TreeSortUtil() {
        this.newTreeNodes = new ArrayList<TreeNode<ID>>();
    }

    public static <T extends Serializable> TreeSortUtil<T> create() {
        TreeSortUtil<T> treeSortUtil = new TreeSortUtil<T>();
        return treeSortUtil;
    }

    /**
     * 获得根节点
     *
     * @param trees
     */
    public List<TreeNode<ID>> getTopNodes() {
        List<TreeNode<ID>> list = new ArrayList<TreeNode<ID>>();
        for(TreeNode<ID> treeable : treeNodes) {
            if (treeable.isRoot()) {
                list.add(treeable);
            }
        }
        return list;
    }

    /**
     * 解析根节点
     *
     * @param trees
     */
    public void parseSubNode(TreeNode<ID> node) {
        for(TreeNode<ID> treeable : treeNodes) {
            if (!ObjectUtils.isNullOrEmpty(treeable.getParentId()) && treeable.getParentId().equals(node.getId())) {
                newTreeNodes.add(treeable);
                parseSubNode(treeable);
            }
        }
    }

    /**
     * 运行排序
     */
    @SuppressWarnings("unchecked")
    public TreeSortUtil<ID> sort(List<?> treeNodes) {
        this.treeNodes = (List<TreeNode<ID>>) treeNodes;
        List<TreeNode<ID>> rootNodes = getTopNodes();
        for(TreeNode<ID> rootNode : rootNodes) {
            newTreeNodes.add(rootNode);
            parseSubNode(rootNode);
        }
        this.treeNodes.clear();
        this.treeNodes.addAll(newTreeNodes);
        return this;
    }

    /**
     * 运行排序
     */
    @SuppressWarnings("unchecked")
    public TreeSortUtil<ID> async(List<?> treeNodes) {
        this.treeNodes = (List<TreeNode<ID>>) treeNodes;
        for(TreeNode<ID> treeNode : this.treeNodes) {
            treeNode.setLoaded(true);
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    public TreeSortUtil<ID> sync(List<?> treeNodes) {
        this.treeNodes = (List<TreeNode<ID>>) treeNodes;
        for(TreeNode<ID> treeNode : this.treeNodes) {
            treeNode.setLoaded(false);
        }
        return this;
    }

}
