package com.saumrit.restclientdemo.controller;


import com.saumrit.restclientdemo.dto.client.StudentDTO;
import com.saumrit.restclientdemo.service.V1Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
