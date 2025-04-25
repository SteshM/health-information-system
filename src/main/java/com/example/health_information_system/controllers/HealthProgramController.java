package com.example.health_information_system.controllers;

import com.example.health_information_system.dtos.requests.HealthProgramCreateDTO;
import com.example.health_information_system.dtos.responses.ResponseDTO;
import com.example.health_information_system.dtos.responses.StatusCodes;
import com.example.health_information_system.services.HealthProgramService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/program")
@RestController
@RequiredArgsConstructor
public class HealthProgramController {
    private final HealthProgramService healthProgramService;

    @PostMapping("/create")
    public ResponseDTO<HealthProgramCreateDTO>createHealthProgram(
            @Valid @RequestBody HealthProgramCreateDTO healthProgramCreateDTO
    ){
        healthProgramService.createProgram(healthProgramCreateDTO);
        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "successfully created a health program"
        );

    }
}
