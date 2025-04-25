package com.example.health_information_system.repositories;

import com.example.health_information_system.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClientRepo extends JpaRepository<ClientEntity,Long>,
        JpaSpecificationExecutor<ClientEntity> {
}
