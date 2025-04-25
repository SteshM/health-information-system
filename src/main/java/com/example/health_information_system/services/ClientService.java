package com.example.health_information_system.services;

import com.example.health_information_system.dtos.requests.ClientCreateDTO;
import com.example.health_information_system.models.ClientEntity;
import com.example.health_information_system.repositories.ClientRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
