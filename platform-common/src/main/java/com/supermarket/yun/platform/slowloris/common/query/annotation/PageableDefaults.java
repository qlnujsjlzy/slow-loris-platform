package com.supermarket.yun.platform.slowloris.common.query.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * https://github.com/synyx/hades/tree/master/hades/src/main/java/org/synyx/
 * hades 默认的分页数据，先从参数找，参数找不到从方法上找
 * </p>
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/21 23:32
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageableDefaults {

    /**
     * The default-size the injected
     * corresponding parameter defined in request (default is 10).
     */
    int value() default 10;

    /**
     * The default-pagenumber the injected
     * parameter defined in request (default is 0).
     */
    int pageNumber() default 0;

    /**
     * 默认的排序 格式为{"a=desc, a.b=desc"}
     */
    String[] sort() default {};

}
