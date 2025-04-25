package com.example.health_information_system.repositories;

import com.example.health_information_system.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientEntity,Long> {
}
