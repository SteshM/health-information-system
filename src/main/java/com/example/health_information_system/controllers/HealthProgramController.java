package com.example.health_information_system.controllers;

import com.example.health_information_system.dtos.requests.HealthProgramCreateDTO;
import com.example.health_information_system.dtos.responses.ProgramDTO;
import com.example.health_information_system.dtos.responses.ResponseDTO;
import com.example.health_information_system.dtos.responses.StatusCodes;
import com.example.health_information_system.mappers.HealthProgramMapper;
import com.example.health_information_system.services.HealthProgramService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RequestMapping("/v1/program")
@RestController
@RequiredArgsConstructor
public class HealthProgramController {
    private final HealthProgramService healthProgramService;
    private final HealthProgramMapper healthProgramMapper;

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

    @GetMapping("view")
    public ResponseDTO<ProgramDTO>viewProgram(
            @PathVariable Long id
    ){
       var healthProgram = healthProgramMapper.map
               (healthProgramService.getHealthProgram(id));
       return new ResponseDTO<>(
               StatusCodes.SUCCESS,
               "Successfully fetched a health program",
               Collections.singletonList(healthProgram)
       );
    }

}
