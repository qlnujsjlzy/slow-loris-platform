package com.supermarket.yun.platform.slowloris.common.query.parse;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.supermarket.yun.platform.slowloris.common.query.data.Condition;
import com.supermarket.yun.platform.slowloris.common.query.data.Condition.Filter;
import com.supermarket.yun.platform.slowloris.common.query.data.Condition.Operator;
import com.supermarket.yun.platform.slowloris.common.query.data.Queryable;
import com.supermarket.yun.platform.slowloris.common.utils.ObjectUtils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

/**
 * 查询条件转换成 wrapper
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/20 20:13
 */
public class QueryToWrapper<T> {

    public void parseCondition(Wrapper<T> wrapper, Queryable queryable) {
        Condition condition = queryable.getCondition();
        if (condition != null) {
            for(Filter filter : condition) {
                Object value = filter.getValue();
                if (!ObjectUtils.isNullOrEmpty(value)) {
                    // 可以使用反射快速绑定
                    Operator operator = filter.getOperator();
                    String property = filter.getProperty();
                    if (operator == Operator.custom) {
                        continue;
                    } else if (operator == Operator.isNull) {
                        wrapper.isNull(property);
                    } else if (operator == Operator.isNotNull) {
                        wrapper.isNotNull(property);
                    } else if (operator == Operator.between) {
                        Object[] between = null;
                        if (value instanceof List) {
                            between = ((List<?>) value).toArray(new Object[((List<?>) value).size()]);
                        } else {
                            between = (Object[]) value;
                        }
                        if (between.length == 2) {
                            wrapper.between(property, between[0], between[1]);
                        }
                    } else if (operator.name().toUpperCase(Locale.US).contains("LIKE")) {
                        value = parseLike(filter);
                        if (operator.name().contains("NOT")) {
                            wrapper.notLike(filter.getProperty(), (String) value);

                        } else {
                            wrapper.like(filter.getProperty(), (String) value);
                        }
                    } else {
                        //wrapper.eq(filter.getProperty(),  value);
                        invokeWrapper(wrapper, filter);
                    }
                }
            }
        }

    }

    public Object parseLike(Filter filter) {
        String operatorStr = filter.getOperator().name().toUpperCase(Locale.US);
        Object value = filter.getValue();
        if (operatorStr.contains("PREFIX")) {
            value = "%" + value;
        } else if (operatorStr.contains("SUFFIX")) {
            value = value + "%";
        } else {
            value = "%" + value + "%";
        }
        return value;
    }

    /**
     * @param filter
     * @return
     */
    public void invokeWrapper(Wrapper<T> wrapper, Filter filter) {
        try {
            Method method = wrapper.getClass().getMethod(filter.getOperator().name(), String.class,
                    Object.class);
            method.invoke(wrapper, filter.getProperty(), filter.getValue());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void parseSort(Wrapper<T> wrapper, Queryable queryable) {
        com.supermarket.yun.platform.slowloris.common.query.data.Sort sort = queryable.getPageable().getSort();
        if (sort != null) {
            for(com.supermarket.yun.platform.slowloris.common.query.data.Sort.Order order : sort) {
                if (order.getDirection() == com.supermarket.yun.platform.slowloris.common.query.data.Sort.Direction.DESC) {
                    wrapper.orderBy(order.getProperty(), false);
                } else if (order.getDirection() == com.supermarket.yun.platform.slowloris.common.query.data.Sort.Direction.ASC) {
                    wrapper.orderBy(order.getProperty(), true);
                }
            }
        }
    }

}
