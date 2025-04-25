package com.example.health_information_system.services;
import com.example.health_information_system.dtos.requests.ClientCreateDTO;
import com.example.health_information_system.models.ClientEntity;
import com.example.health_information_system.models.HealthProgramEntity;
import com.example.health_information_system.repositories.ClientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
public class ClientService {
    ModelMapper modelMapper = new ModelMapper();
    private final ClientRepo clientRepo;

    public void createClient(
            @Valid ClientCreateDTO clientCreateDTO) {
        ClientEntity clientEntity = modelMapper.map(
                clientCreateDTO,ClientEntity.class);
        clientRepo.save(clientEntity);

    }

    public Page<ClientEntity> searchClients(
            Pageable page, ClientEntity client) {

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreCase();
        Example<ClientEntity> example = Example.of(client, exampleMatcher);

        return clientRepo.findAll(example, page);

    }

    public ClientEntity getClient(Long id) {
        return clientRepo.findById(id).orElseThrow(()
                -> new NoSuchElementException("client not found"));

    }

    public ClientEntity updateClientDetails(
            Long id, ClientCreateDTO clientCreateDTO) {
        var clientEntity = clientRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("client not found"));
        Optional.ofNullable(clientCreateDTO.getFirstName()).ifPresent(clientEntity::setFirstName);
        Optional.ofNullable(clientCreateDTO.getLastName()).ifPresent(clientEntity::setLastName);
        Optional.ofNullable(clientCreateDTO.getGender()).ifPresent(clientEntity::setGender);
        Optional.ofNullable(clientCreateDTO.getEmail()).ifPresent(clientEntity::setEmail);
        Optional.ofNullable(clientCreateDTO.getDateOfBirth()).ifPresent(clientEntity::setDateOfBirth);
        Optional.ofNullable(clientCreateDTO.getPhoneNumber()).ifPresent(clientEntity::setPhoneNumber);
        Optional.ofNullable(clientCreateDTO.getPassword()).ifPresent(clientEntity::setPassword);
        Optional.ofNullable(clientCreateDTO.getMetaData()).ifPresent(clientEntity::setMetaData);

        return clientRepo.save(clientEntity);

    }

    public void deleteClient(Long id) {
        // Check if the client exists
        Optional<ClientEntity> existingClient = clientRepo.findById(id);
        if (existingClient.isEmpty()) {
            throw new RuntimeException("client not found with ID: " + id);
        }
        clientRepo.deleteById(id);

    }
}
