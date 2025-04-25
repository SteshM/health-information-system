package com.example.health_information_system.repositories;

import com.example.health_information_system.models.HealthProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthProgramRepo extends JpaRepository<HealthProgramEntity,Long> {
}
