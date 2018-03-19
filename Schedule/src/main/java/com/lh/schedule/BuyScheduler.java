package com.lh.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @version :1.0
 * CREATE TIME :2018/3/14 20:04
 * @authro :LH
 */
public class BuyScheduler {

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("money","100");
        jobDataMap.put("thing","垃圾");
        JobDetail jobDetail = JobBuilder.newJob(BuyJob.class)
                .withIdentity("buyjob","group_1")
                .setJobData(jobDataMap)
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("buyTigger","group_1")
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5).withRepeatCount(2))
                .build();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
