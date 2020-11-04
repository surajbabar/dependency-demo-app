package com.thoughtworks.dependencydemoapp.batch;

public class Job {
    private String cronExpression;
    private String name;

    public Job() {
    }

    public Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Override
    public String toString() {
        return "Job{" +
                "cronExpression='" + cronExpression + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
