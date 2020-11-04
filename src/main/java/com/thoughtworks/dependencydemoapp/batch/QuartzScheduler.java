package com.thoughtworks.dependencydemoapp.batch;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.stereotype.Component;

import java.text.ParseException;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Component
public class QuartzScheduler {
    private final Scheduler scheduler;

    public QuartzScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void scheduleBatch(Job job) throws SchedulerException, ParseException {
        if ("HelloWorldJob".equals(job.getName())) {
            JobDetail jobDetail = newJob(HelloWorldJob.class)
                    .withIdentity("job-1", "time-based-jobs")
                    .build();
            Trigger trigger = newTrigger()
                    .withIdentity("trigger-1", "time-based-jobs")
                    .withSchedule(cronSchedule(job.getCronExpression()))
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        }

    }
}
