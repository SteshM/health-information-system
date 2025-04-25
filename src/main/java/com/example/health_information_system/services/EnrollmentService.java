package com.example.health_information_system.services;

import com.example.health_information_system.dtos.requests.ProgramEnrolDTO;
import com.example.health_information_system.dtos.responses.ClientDTO;
import com.example.health_information_system.mappers.ClientMapper;
import com.example.health_information_system.models.ClientEntity;
import com.example.health_information_system.models.ClientProgramEnrollment;
import com.example.health_information_system.models.HealthProgramEntity;
import com.example.health_information_system.repositories.ClientRepo;
import com.example.health_information_system.repositories.EnrollmentRepo;
import com.example.health_information_system.repositories.HealthProgramRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final ClientRepo clientRepo;
    private final HealthProgramRepo healthProgramRepo;
    private final EnrollmentRepo enrollmentRepo;
    private final ClientMapper clientMapper;

    public void enrolToProgram(ProgramEnrolDTO programEnrolDTO) {
        ClientProgramEnrollment clientProgramEnrollment = new ClientProgramEnrollment();
        clientProgramEnrollment.setEnrollmentDate(programEnrolDTO.getEnrollmentDate());
        ClientEntity client = clientRepo.findById(programEnrolDTO.getClientId())
                .orElseThrow(() -> new NoSuchElementException("client not found"));

        for (Long healthProgramId : programEnrolDTO.getHealthProgramIds()) {
            HealthProgramEntity healthProgram = healthProgramRepo.findById(healthProgramId)
                    .orElseThrow(() -> new NoSuchElementException("program not found"));

            enrollmentRepo.save(ClientProgramEnrollment.builder()
                    .client(client).program(healthProgram)
                    .enrollmentDate(programEnrolDTO.getEnrollmentDate()).build());


        }
    }


    public List<ClientDTO> getClientsByProgram(Long programId) {
        HealthProgramEntity healthProgram = healthProgramRepo.findById(programId)
                .orElseThrow(() -> new NoSuchElementException("Program not found"));

        List<ClientProgramEnrollment> enrollments = enrollmentRepo.findByProgram(healthProgram);

        // Map enrollments to client DTOs
        List<ClientDTO> clientDTOs;
        clientDTOs = enrollments.stream()
                .map(enrollment -> clientMapper.map(enrollment.getClient()))
                .collect(Collectors.toList());

        return clientDTOs;
    }



}
