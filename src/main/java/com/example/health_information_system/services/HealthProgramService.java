package com.example.health_information_system.services;

import com.example.health_information_system.dtos.requests.HealthProgramCreateDTO;
import com.example.health_information_system.dtos.responses.ProgramDTO;
import com.example.health_information_system.models.HealthProgramEntity;
import com.example.health_information_system.repositories.HealthProgramRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Page<HealthProgramEntity> searchHealthPrograms(
            Pageable page, HealthProgramEntity healthPrograms) {

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreCase();
        Example<HealthProgramEntity> example = Example.of(healthPrograms, exampleMatcher);

        return healthProgramRepo.findAll(example, page);



    }

    public HealthProgramEntity updateHealthProgram(
            Long id,HealthProgramCreateDTO healthProgramCreateDTO) {
        var healthProgram = healthProgramRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("healthProgram not found"));
        Optional.ofNullable(healthProgramCreateDTO.getName()).ifPresent(healthProgram::setName);
        Optional.ofNullable(healthProgram.getDescription()).ifPresent(healthProgram::setDescription);
        Optional.ofNullable(healthProgram.getStartDate()).ifPresent(healthProgram::setStartDate);
        Optional.ofNullable(healthProgram.getEndDate()).ifPresent(healthProgram::setEndDate);
        return healthProgramRepo.save(healthProgram);

    }
}
