package com.lh.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @version :1.0
 * CREATE TIME :2018/3/15 11:28
 * @authro :LH
 */
public class MoneyJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("发送提醒。。。。");
    }
}
