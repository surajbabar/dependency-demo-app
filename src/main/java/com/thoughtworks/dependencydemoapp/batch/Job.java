package com.thoughtworks.dependencydemoapp.batch;

public class Job {
    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                '}';
    }

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
}
