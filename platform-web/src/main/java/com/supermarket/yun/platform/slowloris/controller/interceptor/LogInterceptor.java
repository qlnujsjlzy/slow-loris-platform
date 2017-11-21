package com.supermarket.yun.platform.slowloris.controller.interceptor;

import com.supermarket.yun.platform.slowloris.common.utils.DateUtils;
import com.supermarket.yun.platform.slowloris.service.utils.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/16 0:07
 */
public class LogInterceptor implements HandlerInterceptor {

    private final static Logger LOGGER = LogManager.getLogger();
    private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");
    private Boolean openAccessLog = Boolean.FALSE;

    public void setOpenAccessLog(Boolean openAccessLog) {
        this.openAccessLog = openAccessLog;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            long beginTime = System.currentTimeMillis(); // 1、开始时间
            startTimeThreadLocal.set(beginTime);         // 线程绑定变量（该数据只有当前请求的线程可见）
            LOGGER.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime), request.getRequestURI());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            LOGGER.info("ViewName: {}", modelAndView.getViewName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (openAccessLog) {
            // 保存日志
            LogUtils.saveLog(request, handler, ex, null);
            // 打印JVM信息。
            if (LOGGER.isDebugEnabled()) {
                long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
                long endTime = System.currentTimeMillis(); // 2、结束时间
                LOGGER.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
                        new SimpleDateFormat("hh:mm:ss.SSS").format(endTime),
                        DateUtils.formatDateTime(endTime - beginTime), request.getRequestURI(),
                        Runtime.getRuntime().maxMemory() / 1024 / 1024,
                        Runtime.getRuntime().totalMemory() / 1024 / 1024,
                        Runtime.getRuntime().freeMemory() / 1024 / 1024,
                        (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()) / 1024 / 1024);
            }
        }

    }

}
