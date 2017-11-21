package com.supermarket.yun.platform.slowloris.common.query.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 先从参数找，参数找不到从方法上找，否则使用默认的查询参数
 * </p>
 * <p>
 * <pre>
 *     格式如下：
 *     value = {"baseInfo.age_lt=123", "name_like=abc", "id_in=1,2,3,4"}
 * </pre>
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:32
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryableDefaults {

    /**
     * 默认查询参数字符串
     *
     * @return
     */
    String[] value() default {};

    /**
     * 是否合并默认的与自定义的
     *
     * @return
     */
    boolean merge() default false;

    /**
     * 是否需要分页
     *
     * @return
     */
    boolean needPage() default true;

    /**
     * 是否需要排序
     *
     * @return
     */
    boolean needSort() default true;
}
