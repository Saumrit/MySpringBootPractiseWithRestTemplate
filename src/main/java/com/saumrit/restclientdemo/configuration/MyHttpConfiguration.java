package com.saumrit.restclientdemo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
@Setter
public class MyHttpConfiguration {

    @Value("${studentService.getAllStudents.uri}")
    public String studentServiceURI;

    @Value("${studentService.getSingleStudentOnly.uri}")
    public String studentServiceForSingleStudentFromCollegeURI;

    @Bean
    public RestTemplate getTheRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RestClient getTheRestClient(){
        return RestClient.create();
    }




}
