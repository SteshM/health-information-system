package com.example.health_information_system.repositories;

import com.example.health_information_system.models.ClientProgramEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<ClientProgramEnrollment,Long> {
}
