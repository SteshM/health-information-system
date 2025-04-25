package com.example.health_information_system.mappers;

import com.example.health_information_system.dtos.responses.ClientDTO;
import com.example.health_information_system.models.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface ClientMapper {

    ClientDTO map(ClientEntity entity);

    @Mapping(target = "clientId", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "dateOfBirth", ignore = true)
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "phoneNumber", ignore = true)
    @Mapping(target = "metaData", ignore = true)
    ClientEntity map(ClientDTO clientDTO);
}
