package com.example.health_information_system.services;

import com.example.health_information_system.dtos.requests.ClientCreateDTO;
import com.example.health_information_system.models.ClientEntity;
import com.example.health_information_system.repositories.ClientRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
}
