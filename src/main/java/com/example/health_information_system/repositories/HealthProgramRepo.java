package com.example.health_information_system.repositories;

import com.example.health_information_system.models.HealthProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HealthProgramRepo extends JpaRepository<HealthProgramEntity,Long>,
        JpaSpecificationExecutor<HealthProgramEntity> {
}
