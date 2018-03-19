package com.lh.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @version :1.0
 * CREATE TIME :2018/3/14 19:21
 * @authro :LH
 */
public class HelloJob implements Job{
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("主线任务");
    }
}
