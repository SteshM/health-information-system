package com.example.health_information_system.controllers;

import com.example.health_information_system.dtos.requests.ProgramEnrolDTO;
import com.example.health_information_system.dtos.responses.ClientDTO;
import com.example.health_information_system.dtos.responses.ResponseDTO;
import com.example.health_information_system.dtos.responses.StatusCodes;
import com.example.health_information_system.services.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {
    private static final String ENROL_PROGRAM = "/enrol";
    private static final String FETCH_BY_PROGRAM = "/program/{programId}/clients";

    private final EnrollmentService enrollmentService;

    @PostMapping(ENROL_PROGRAM)
    public ResponseDTO<ProgramEnrolDTO>programEnrol(
           @Valid @RequestBody ProgramEnrolDTO programEnrolDTO){
        enrollmentService.enrolToProgram(programEnrolDTO);
        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Enrolled client to a program successfully"
        );

    }


    @GetMapping(FETCH_BY_PROGRAM)
    public ResponseDTO<ClientDTO> getClientsByProgram(
            @PathVariable Long programId) {
        List<ClientDTO> clientDTOs = enrollmentService.
                getClientsByProgram(programId);
        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Successfully fetched clients enrolled in program",
                clientDTOs
        );
    }








}
