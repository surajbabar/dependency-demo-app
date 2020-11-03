package com.thoughtworks.dependencydemoapp.batch;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Component
public class QuartzScheduler {
    private Scheduler scheduler;

    public QuartzScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void scheduleBatch(Job job) throws SchedulerException, InterruptedException {
        if ("HelloWorldJob".equals(job.getName())) {
            JobDetail jobDetail = newJob(HelloWorldJob.class)
                    .withIdentity("job-1", "time-based-jobs")
                    .build();
            Date runTime = evenMinuteDate(new Date());
            Trigger trigger = newTrigger()
                    .withIdentity("trigger-1", "time-based-jobs")
                    .startAt(runTime)
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            Thread.sleep(5L * 1000L);
            scheduler.shutdown(true);
        }

    }
}
