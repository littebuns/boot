package com.example.jar.quartz.boot.controller;

import com.example.jar.quartz.boot.job.HelloJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloJobController {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @GetMapping("/hello")
    public void hello(@RequestParam("no") String no){
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobDetail detail = JobBuilder.newJob(HelloJob.class).withIdentity(no).build();
        Trigger simpleTrigger = TriggerBuilder.newTrigger()
                .startAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.SECOND))
                .build();
        try {
            scheduler.deleteJob(new JobKey(no));
            scheduler.scheduleJob(detail, simpleTrigger);
            log.info("注册一次任务,触发时间为{}", DateBuilder.futureDate(10, DateBuilder.IntervalUnit.SECOND));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
