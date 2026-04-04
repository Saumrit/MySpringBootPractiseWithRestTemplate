package com.saumrit.restclientdemo.client.impl;

import com.saumrit.restclientdemo.client.StudentServiceRestClient;
import com.saumrit.restclientdemo.configuration.MyHttpConfiguration;
import com.saumrit.restclientdemo.dto.client.StudentDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentServiceRestClientImpl implements StudentServiceRestClient {

    public final RestTemplate restTemplate;
    public final RestClient restClient;
    public final MyHttpConfiguration myHttpConfiguration;

    public StudentServiceRestClientImpl(RestTemplate restTemplate, RestClient restClient, MyHttpConfiguration myHttpConfiguration) {
        this.restTemplate = restTemplate;
        this.restClient = restClient;
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

    @Override
    public List<StudentDTO> fetchAllStudentsByRestClient() {
        ResponseEntity<List<StudentDTO>> theResponse = restClient.get()
                .uri(myHttpConfiguration.getStudentServiceURI())
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<StudentDTO>>() {});
        return theResponse.getBody();
    }

    @Override
    public StudentDTO fetchAStudentFromACollege(String collegeName, String studentName) {
        Map<String,Object> theURIvariables= new HashMap<>();
        theURIvariables.put("collegeName",collegeName);
        URI theUri=UriComponentsBuilder.fromUriString(myHttpConfiguration.getStudentServiceForSingleStudentFromCollegeURI())
                .queryParam("studentName",studentName)
                .uriVariables(theURIvariables)
                .build().toUri();

        ResponseEntity<StudentDTO> theResponse= restTemplate.getForEntity(theUri,StudentDTO.class);

        return theResponse.getBody();
    }

    @Override
    public StudentDTO fetchAStudentFromACollegeByRestClient(String collegeName, String studentName) {
        Map<String,Object> theURIvariables= new HashMap<>();
        theURIvariables.put("collegeName",collegeName);
        URI theUri=UriComponentsBuilder.fromUriString(myHttpConfiguration.getStudentServiceForSingleStudentFromCollegeURI())
                .queryParam("studentName",studentName)
                .uriVariables(theURIvariables)
                .build().toUri();
        ResponseEntity<StudentDTO> theResponse=restClient.get()
                .uri(theUri.getPath(),theURIvariables)
                .retrieve()
                .toEntity(StudentDTO.class);

        return theResponse.getBody();

    }
}
