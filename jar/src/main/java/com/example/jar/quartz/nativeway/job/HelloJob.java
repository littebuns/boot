package com.example.jar.quartz.nativeway.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("j1:{}", context.getJobDetail().getJobDataMap().get("j1") );
        log.info("j2:{}", context.getJobDetail().getJobDataMap().get("j2") );
        log.info("t1:{}", context.getTrigger().getJobDataMap().get("t1") );
        log.info("t2:{}", context.getTrigger().getJobDataMap().get("t2") );
        System.out.println("Hello World");
    }

}
