package com.example.health_information_system.repositories;

import com.example.health_information_system.models.ClientEntity;
import com.example.health_information_system.models.ClientProgramEnrollment;
import com.example.health_information_system.models.HealthProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepo extends JpaRepository<ClientProgramEnrollment,Long> {
    List<ClientProgramEnrollment> findByClient(ClientEntity client);
    List<ClientProgramEnrollment> findByProgram(HealthProgramEntity program);


}
