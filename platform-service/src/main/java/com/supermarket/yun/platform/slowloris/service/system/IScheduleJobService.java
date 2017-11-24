package com.supermarket.yun.platform.slowloris.service.system;

import com.supermarket.yun.platform.slowloris.common.ICommonService;
import com.supermarket.yun.platform.slowloris.domain.system.ScheduleJob;
import org.quartz.SchedulerException;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:14
 */
public interface IScheduleJobService extends ICommonService<ScheduleJob> {
    /**
     * @throws SchedulerException
     * @title: initSchedule
     * @description: 初始化任务
     * @return: void
     */
    public void initSchedule() throws SchedulerException;

    /**
     * 更改状态
     *
     * @throws SchedulerException
     */
    public void changeStatus(String jobId, String cmd) throws SchedulerException;

    /**
     * 更改任务 cron表达式
     *
     * @throws SchedulerException
     */
    public void updateCron(String jobId) throws SchedulerException;
}
