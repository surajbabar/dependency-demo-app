package com.thoughtworks.dependencydemoapp.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.jcip.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleDataController {

    public static final Logger log = LoggerFactory.getLogger(SampleDataController.class);

    @GetMapping(path = "/data")
    public Data getData() {
        return new Data("Hello World !!!!!");
    }

    @PostMapping(path = "data")
    public ResponseEntity<String> updateData(@RequestBody String request) throws JsonProcessingException {

        log.info("post data: {}",request);
        
        Data data = deserialize(request);
        if (data != null) {

            return new ResponseEntity<String>(data.toString(),HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("invalid content", HttpStatus.BAD_REQUEST);
        }
    }

    private static Data deserialize(String request) {
        try {
            return new ObjectMapper().readValue(request, Data.class);
        } catch (Exception e) {
            log.info("Unexpected exception deserializing content: ", e);
            return null;
        }
    }


}
@Immutable
class Data {
    private Object value;
    Data() {

    }
    Data(String value) {

        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" +
                "value=" + value +
                '}';
    }
}