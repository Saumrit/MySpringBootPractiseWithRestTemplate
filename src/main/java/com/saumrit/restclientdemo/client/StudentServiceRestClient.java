package com.saumrit.restclientdemo.client;

import com.saumrit.restclientdemo.dto.client.StudentDTO;

import java.util.List;

public interface StudentServiceRestClient {

    List<StudentDTO> fetchAllStudents();
    List<StudentDTO> fetchAllStudentsByRestClient();

    StudentDTO fetchAStudentFromACollege(String collegeName, String studentName);
    StudentDTO fetchAStudentFromACollegeByRestClient(String collegeName, String studentName);

    Integer addASingleStudent(StudentDTO studentDTO);
    Integer addASingleStudentByRestClient(StudentDTO studentDTO);
}
