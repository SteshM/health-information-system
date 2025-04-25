package com.example.health_information_system.controllers;

import com.example.health_information_system.dtos.requests.ClientCreateDTO;
import com.example.health_information_system.dtos.responses.ClientDTO;
import com.example.health_information_system.dtos.responses.ResponseDTO;
import com.example.health_information_system.dtos.responses.StatusCodes;
import com.example.health_information_system.mappers.ClientMapper;
import com.example.health_information_system.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/client")
@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @PostMapping("create")
    public ResponseDTO<ClientCreateDTO>createClient(
            @Valid @RequestBody()ClientCreateDTO clientCreateDTO
    ){
        clientService.createClient(clientCreateDTO);
        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Successfully created a client"
        );
    }

    @GetMapping("/search")
    Page<ClientDTO> searchClients(
            Pageable page,
            ClientDTO clients
    ){
        var client= clientMapper.map(clients);
        return clientService.searchClients(page,client)
                .map(clientMapper::map);

    }


}
