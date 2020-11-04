package com.thoughtworks.dependencydemoapp.batch;

import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class BatchController {

    private QuartzScheduler scheduler;

    public BatchController(QuartzScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @PostMapping(path = "triggerJob")
    public ResponseEntity<String> triggerJob(@RequestBody Job job) throws SchedulerException, ParseException {
        if (job != null) {

            scheduler.scheduleBatch(job);
            return new ResponseEntity<>(" successfully triggered Job", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("invalid request", HttpStatus.BAD_REQUEST);
        }
    }

}
