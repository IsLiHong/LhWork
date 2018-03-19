package com.lh.schedule;

import com.lh.utils.SchedulerUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @version :1.0
 * CREATE TIME :2018/3/15 19:43
 * @authro :LH
 */
public class CronScheduler {

    public static void main(String[] args) throws Exception{
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("money",100.0);
        jobDataMap.put("thing","cai");
        JobDetail jobDetail = JobBuilder.newJob(BuyJob.class).withIdentity("buyJob","group_1").setJobData(jobDataMap).build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("buyJobTrigger","group_1").withSchedule(CronScheduleBuilder.cronSchedule("0/5 0-50 20-22 * * ? *")).build();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
        SchedulerUtils.modify("buyJob","group_1","buyJobTrigger","group_1","0/2 0-59 20-22 * * ? *");
    }
}
