package com.example.health_information_system.controllers;

import com.example.health_information_system.dtos.requests.ClientCreateDTO;
import com.example.health_information_system.dtos.responses.ResponseDTO;
import com.example.health_information_system.dtos.responses.StatusCodes;
import com.example.health_information_system.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/client")
@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

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
}
