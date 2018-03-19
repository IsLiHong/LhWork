package com.lh.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @version :1.0
 * CREATE TIME :2018/3/14 19:22
 * @authro :LH
 */
public class HelloSchedule {

    public static void main(String[] args)throws  Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob","job_group")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("helloJobTrigger","trigger_group")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).withRepeatCount(3))
                .build();

        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
