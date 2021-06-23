package com.example.boot.jar.quartz;

import org.junit.jupiter.api.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 原生的方式调用Quartz
 */
public class QuartzTest {


    @Test
    public void test() throws SchedulerException, InterruptedException {
        //创建job
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();
        //创建触发器
        CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("*/1 * * * * ?")).build();
        //创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        Thread.sleep(10000);
    }
}
