package com.thoughtworks.dependencydemoapp.batch;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

    private QuartzScheduler scheduler;

    public BatchController(QuartzScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @PostMapping(path = "triggerJob")
    public ResponseEntity<String> triggerJob(@RequestBody Job job) throws JsonProcessingException, InterruptedException, SchedulerException {
        if (job != null) {

            scheduler.scheduleBatch(job);
            return new ResponseEntity<String>(" successfully triggered Job", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("invalid request", HttpStatus.BAD_REQUEST);
        }
    }

}
