package com.thoughtworks.dependencydemoapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperProvider {

//    @Bean
//    public static ObjectMapper jacksonObjectMapper()
//    {
//        return new ObjectMapper();
//    }

//    @Bean
//    public static MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper)
//    {
//        return new Jackson2ObjectMapperBuilder().build(<MappingJackson2HttpMessageConverter>)
//    }
}
