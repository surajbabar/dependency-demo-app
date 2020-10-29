package com.thoughtworks.dependencydemoapp.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleDataController {
    @GetMapping(path = "/data")
    public Data getData() {
        return new Data("Hello World !!!!!");
    }

}

class Data {
    private String data;

    Data(String data) {

        this.data = data;
    }

    public String getData() {
        return data;
    }
}