package com.example.jar.quartz.nativeway;


import com.example.jar.quartz.boot.job.HelloJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 关于 Quartz 的一个快速应用
 */
public class QuickStart {

    public static void main(String[] args) {
        try {
            //获取调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //启动
            scheduler.start();

            //创建一个简单任务
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("j1","jv1")
                    .build();
            jobDetail.getJobDataMap().put("j2","jv2");

            //创建触发器
            Trigger trigger= TriggerBuilder.newTrigger()
                    .withIdentity("trigger1","trigger1")
                    .usingJobData("t1","tv1")
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                    .build();
            trigger.getJobDataMap().put("t2","tv2");

            //注册该任务到调度器中
            scheduler.scheduleJob(jobDetail, trigger);

            Thread.sleep(30000);
            //关闭
            scheduler.shutdown();
        } catch (SchedulerException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
