package com.example.jar.quartz.nativeway.trigger;

import com.example.jar.quartz.nativeway.job.HelloJob;
import org.junit.jupiter.api.Test;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTrigger {

    private Scheduler scheduler;
    private JobDetail jobDetail;

    {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            jobDetail = JobBuilder.newJob(HelloJob.class)
                    .usingJobData("j1","jv1")
                    .build();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t1() throws SchedulerException, InterruptedException {

        Trigger simpleTrigger = TriggerBuilder.newTrigger()
                .startAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.SECOND))
                .build();

        scheduler.start();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        Thread.sleep(70000);
        scheduler.shutdown();

    }


}
