package com.supermarket.yun.platform.slowloris.common.query.data;

/**
 * 查询接口
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 0:38
 */
public interface Queryable {
    /**
     * 获得分页
     *
     * @return
     */
    public Pageable getPageable();

    public void setPageable(Pageable pageable);

    /**
     * 获得排序
     *
     * @return
     */
    public void addSort(Sort sort);

    /**
     * 获得查询条件
     *
     * @return
     */
    public Condition getCondition();

    public void setCondition(Condition condition);

    /**
     * 通过字段获得值，方便自定义查询
     *
     * @return
     */
    public Object getValue(String property);

    /**
     * 添加条件
     *
     * @param property
     * @param value
     * @return
     */
    public Queryable addCondition(final String property, final Object value);

    /**
     * 移出条件，方便自定义条件
     *
     * @param property
     */
    public void removeCondition(String property);

    /**
     * @return
     */
    public boolean isConverted();

}
