package com.lh.utils;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @version :1.0
 * CREATE TIME :2018/3/15 19:33
 * @authro :LH
 */
public class SchedulerUtils {

    public static void modify(String jobName, String jobGroup, String triggerName, String triggerGroup, String cronExp)throws Exception{
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail = scheduler.getJobDetail(new JobKey(jobName,jobGroup));
        TriggerKey triggerKey = new TriggerKey(triggerName,triggerGroup);
        Trigger trigger = scheduler.getTrigger(triggerKey);
        TriggerBuilder triggerBuilder = trigger.getTriggerBuilder();
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExp));
        scheduler.unscheduleJob(triggerKey);
        scheduler.scheduleJob(jobDetail,triggerBuilder.build());

    }

}
