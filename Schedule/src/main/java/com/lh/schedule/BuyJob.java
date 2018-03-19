package com.lh.schedule;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @version :1.0
 * CREATE TIME :2018/3/14 19:51
 * @authro :LH
 */
public class BuyJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("asdas"+jobDataMap.get("money") + "asfasf" + jobDataMap.get("thing"));
    }
}
