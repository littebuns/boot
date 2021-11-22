package com.example.boot.jar.quartz.config;

import com.example.boot.jar.quartz.Job;
import com.example.boot.jar.quartz.MyJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Autowired
    private Scheduler scheduler;

    @Bean
    public JobDetail myJobDetail(){
        return JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob") //该jobDetail 的id
                .storeDurably()  //没有Trigger 关联也不删除该job
                .usingJobData("msg", "Hello Quartz") //Job 类中通过context获取该Map数据
                .build();
    }

    public static void addJob(Job job){


    }

    public void delJob(JobKey jobKey) throws SchedulerException {

        this.scheduler.deleteJob(jobKey);
    }







}
