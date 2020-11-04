package com.thoughtworks.dependencydemoapp.batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class HelloWorldJob implements Job {
    public static final Logger log = LoggerFactory.getLogger(HelloWorldJob.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Hello World! - " + new Date());
    }
}
