package com.saumrit.restclientdemo.service;

import com.saumrit.restclientdemo.client.StudentServiceRestClient;
import com.saumrit.restclientdemo.dto.client.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class V1Service {

    public final StudentServiceRestClient studentServiceRestClient;

    public V1Service(StudentServiceRestClient studentServiceRestClient) {
        this.studentServiceRestClient = studentServiceRestClient;
    }

    public List<StudentDTO> getAllStudents(){
        return studentServiceRestClient.fetchAllStudents();
    }

    public StudentDTO getSingleStudentFromACollege(String collegeName, String studentName){
        return studentServiceRestClient.fetchAStudentFromACollege(collegeName,studentName);
    }
}
