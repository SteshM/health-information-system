package com.example.health_information_system.controllers;

import com.example.health_information_system.dtos.requests.ProgramEnrolDTO;
import com.example.health_information_system.dtos.responses.ResponseDTO;
import com.example.health_information_system.dtos.responses.StatusCodes;
import com.example.health_information_system.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/enrol")
    public ResponseDTO<ProgramEnrolDTO>programEnrol(
            @RequestBody ProgramEnrolDTO programEnrolDTO){
        enrollmentService.enrolToProgram(programEnrolDTO);
        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Enrolled client to a program successfully"
        );

    }

}
