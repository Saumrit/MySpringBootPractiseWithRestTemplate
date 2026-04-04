package com.saumrit.restclientdemo.client.impl;

import com.saumrit.restclientdemo.client.StudentServiceRestClient;
import com.saumrit.restclientdemo.configuration.MyHttpConfiguration;
import com.saumrit.restclientdemo.dto.client.StudentDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentServiceRestClientImpl implements StudentServiceRestClient {

    public final RestTemplate restTemplate;
    public final MyHttpConfiguration myHttpConfiguration;

    public StudentServiceRestClientImpl(RestTemplate restTemplate, MyHttpConfiguration myHttpConfiguration) {
        this.restTemplate = restTemplate;
        this.myHttpConfiguration = myHttpConfiguration;
    }

    @Override
    public List<StudentDTO> fetchAllStudents() {
        ResponseEntity<List<StudentDTO>> theResponse=restTemplate.exchange(myHttpConfiguration.getStudentServiceURI(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<StudentDTO>>() {})
                ;
        return theResponse.getBody();
    }
}
