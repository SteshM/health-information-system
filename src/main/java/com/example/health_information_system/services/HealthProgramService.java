package com.example.health_information_system.services;

import com.example.health_information_system.dtos.requests.HealthProgramCreateDTO;
import com.example.health_information_system.models.HealthProgramEntity;
import com.example.health_information_system.repositories.HealthProgramRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class HealthProgramService {
    ModelMapper modelMapper = new ModelMapper();
    private final HealthProgramRepo healthProgramRepo;

    public void createProgram(
            @Valid HealthProgramCreateDTO healthProgramCreateDTO) {
        HealthProgramEntity healthProgramEntity = modelMapper.map
                (healthProgramCreateDTO,HealthProgramEntity.class);
        healthProgramRepo.save(healthProgramEntity);

    }

    public HealthProgramEntity getHealthProgram(Long id) {
       return healthProgramRepo.findById(id).orElseThrow(()
               -> new NoSuchElementException("healthProgram not found"));

    }
}
