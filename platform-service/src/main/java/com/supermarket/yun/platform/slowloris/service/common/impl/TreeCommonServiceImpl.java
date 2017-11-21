package com.supermarket.yun.platform.slowloris.service.common.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.supermarket.yun.platform.slowloris.common.base.BaseTreeMapper;
import com.supermarket.yun.platform.slowloris.common.base.TreeNode;
import com.supermarket.yun.platform.slowloris.common.query.data.Queryable;
import com.supermarket.yun.platform.slowloris.common.query.parse.QueryToWrapper;
import com.supermarket.yun.platform.slowloris.common.utils.ObjectUtils;
import com.supermarket.yun.platform.slowloris.service.common.ITreeCommonService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:03
 */
@Transactional
public class TreeCommonServiceImpl<M extends BaseTreeMapper<T>, T extends Serializable & TreeNode<ID>, ID extends Serializable> extends CommonServiceImpl<M, T> implements ITreeCommonService<T, ID> {

    @Override
    public T selectById(Serializable id) {
        return baseMapper.selectByTreeId(id);
    }

    @Override
    public List<T> selectTreeList(Queryable queryable, Wrapper<T> wrapper) {
        // 保证有where字句
        QueryToWrapper<T> queryToWrapper = new QueryToWrapper<T>();
        wrapper.eq("1", "1");
        queryToWrapper.parseCondition(wrapper, queryable);
        // 排序问题
        queryToWrapper.parseSort(wrapper, queryable);
        List<T> content = baseMapper.selectTreeList(wrapper);
        return content;
    }

    @Override
    public List<T> selectTreeList(Wrapper<T> wrapper) {
        // 保证有where字句
        wrapper.eq("1", "1");
        List<T> content = baseMapper.selectTreeList(wrapper);
        return content;
    }

    @Override
    public boolean insert(T entity) {
        if (!ObjectUtils.isNullOrEmpty(entity.getParentId())) {
            T parent = selectById(entity.getParentId());
            entity.setParentId(parent.getId());
            entity.setParentIds(parent.makeSelfAsNewParentIds());
        } else {
            entity.setParentId(null);
        }
        return super.insert(entity);
    }

    @Override
    public boolean insertOrUpdate(T entity) {
        if (!ObjectUtils.isNullOrEmpty(entity.getParentId())) {
            T parent = selectById(entity.getParentId());
            updateSelftAndChild(entity, parent.getId(), parent.makeSelfAsNewParentIds());
        } else {
            entity.setParentId(null);
            updateSelftAndChild(entity, null, null);
        }
        return true;
    }

    private void updateSelftAndChild(T entity, ID newParentId, String newParentIds) {
        T oldEntity = selectById(entity.getId());
        String oldChildrenParentIds = oldEntity.makeSelfAsNewParentIds();
        entity.setParentId(newParentId);
        entity.setParentIds(newParentIds);
        super.insertOrUpdate(entity);
        String newChildrenParentIds = entity.makeSelfAsNewParentIds();
        baseMapper.updateSunTreeParentIds(newChildrenParentIds, oldChildrenParentIds);
    }

	/*// 只允许单个删除
    @Override
	public boolean deleteById(Serializable id) {
		T entity = selectById(id);
		baseMapper.deleteSunTree(entity.makeSelfAsNewParentIds());
		return super.deleteById(id);
	}

	@Override
	public boolean deleteBatchIds(List<? extends Serializable> idList) {
		for (Serializable  treeId: idList) {
			deleteById(treeId);
		}
		return true;
	}*/
}