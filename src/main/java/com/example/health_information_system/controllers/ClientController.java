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

import java.util.Collections;

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

    @GetMapping("/view/{id}")
    public ResponseDTO<ClientDTO>viewClient(
            @PathVariable Long id
    ){
        var client = clientMapper.map
                (clientService.getClient(id));
        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Successfully fetched a client",
                Collections.singletonList(client)
        );
    }

    @PutMapping("/{id}")
    public ResponseDTO<ClientDTO>updateClientDetails(
            @PathVariable() Long id,
            @RequestBody @Valid ClientCreateDTO clientCreateDTO
    ){
        var response = clientMapper.map(
                clientService.updateClientDetails(id,clientCreateDTO));

        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Updated a client's details successfully",
                Collections.singletonList(response)

        );

    }


}
