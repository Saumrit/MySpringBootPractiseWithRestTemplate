package com.saumrit.restclientdemo.controller;


import com.saumrit.restclientdemo.dto.client.StudentDTO;
import com.saumrit.restclientdemo.service.V1Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/v1")
public class V1Controller {

    public final V1Service v1Service;

    public V1Controller(V1Service v1Service) {
        this.v1Service = v1Service;
    }

    @GetMapping("/allStudents")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Api to get All Students",
            description = "Api to get All Students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Success"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error") })
    public List<StudentDTO> getAllStudents(){
        return v1Service.getAllStudents();
    }

    @GetMapping("/studentFromAcollege/{collegeName}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Api to get A student from college",
            description = "Api to get A single student from that colleges")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Success"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error") })
    public StudentDTO getAStudentFromACollege(@PathVariable("collegeName") String collegeName,@RequestParam(name = "theStudentName") String studentName){
        return v1Service.getSingleStudentFromACollege(collegeName,studentName);
    }
}
