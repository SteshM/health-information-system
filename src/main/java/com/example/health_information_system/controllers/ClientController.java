package com.example.health_information_system.controllers;

import com.example.health_information_system.dtos.requests.ClientCreateDTO;
import com.example.health_information_system.dtos.responses.ClientProfileDTO;
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
    private static final String CREATE_CLIENT = "/create";
    private static final String VIEW_CLIENT = "/view/{id}";
    private static final String SEARCH = "/search";
    private static final String CLIENT = "/{id}";
    private static final String CLIENT_PROFILE = "/{clientId}/profile";

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @PostMapping(CREATE_CLIENT)
    public ResponseDTO<ClientCreateDTO>createClient(
            @Valid @RequestBody()ClientCreateDTO clientCreateDTO
    ){
        clientService.createClient(clientCreateDTO);
        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Successfully created a client"
        );
    }


    @GetMapping(SEARCH)
    Page<ClientDTO> searchClients(
            Pageable page,
            ClientDTO clients
    ){
        var client= clientMapper.map(clients);
        return clientService.searchClients(page,client)
                .map(clientMapper::map);

    }


    @GetMapping(VIEW_CLIENT)
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


    @PutMapping(CLIENT)
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


    @DeleteMapping(CLIENT)
    public ResponseDTO<Void> deleteClient(
            @PathVariable() Long id
    ) {
        clientService.deleteClient(id);
        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "client  deleted successfully");
    }


    @GetMapping(CLIENT_PROFILE)
    public ResponseDTO<ClientProfileDTO> getClientProfile(
            @PathVariable Long clientId) {
        // Fetch the client profile, including their enrolled programs
        ClientProfileDTO clientProfile = clientService.getClientProfile(clientId);
        return new ResponseDTO<>(
                StatusCodes.SUCCESS,
                "Successfully fetched client profile",
                Collections.singletonList(clientProfile)
        );
    }

}
