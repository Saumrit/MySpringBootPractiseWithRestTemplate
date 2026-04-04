package com.saumrit.restclientdemo.client;

import com.saumrit.restclientdemo.dto.client.StudentDTO;

import java.util.List;

public interface StudentServiceRestClient {

    List<StudentDTO> fetchAllStudents();

    StudentDTO fetchAStudentFromACollege(String collegeName, String studentName);
}
