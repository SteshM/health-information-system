package com.example.health_information_system.services;

import com.example.health_information_system.dtos.requests.ProgramEnrolDTO;
import com.example.health_information_system.models.ClientEntity;
import com.example.health_information_system.models.ClientProgramEnrollment;
import com.example.health_information_system.models.HealthProgramEntity;
import com.example.health_information_system.repositories.ClientRepo;
import com.example.health_information_system.repositories.EnrollmentRepo;
import com.example.health_information_system.repositories.HealthProgramRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final ClientRepo clientRepo;
    private final HealthProgramRepo healthProgramRepo;
    private final EnrollmentRepo enrollmentRepo;

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
}
