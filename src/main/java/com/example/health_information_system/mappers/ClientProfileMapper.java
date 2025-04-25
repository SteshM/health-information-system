package com.example.health_information_system.mappers;

import com.example.health_information_system.dtos.requests.ClientProfileDTO;
import com.example.health_information_system.dtos.responses.ProgramDTO;
import com.example.health_information_system.models.ClientEntity;
import com.example.health_information_system.models.HealthProgramEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClientProfileMapper {

        @Mapping(target = "clientId", source = "client.clientId")
        @Mapping(target = "firstName", source = "client.firstName")
        @Mapping(target = "lastName", source = "client.lastName")
        @Mapping(target = "email", source = "client.email")
        @Mapping(target = "dateOfBirth", source = "client.dateOfBirth")
        @Mapping(target = "phoneNumber", source = "client.phoneNumber")
        @Mapping(target = "gender", source = "client.gender")
        @Mapping(target = "metaData", source = "client.metaData")
        ClientProfileDTO map(ClientEntity client);

        @Mapping(target = "healthProgramId", source = "program.healthProgramId")
        @Mapping(target = "name", source = "program.name")
        @Mapping(target = "description", source = "program.description")
        @Mapping(target = "startDate", source = "program.startDate")
        @Mapping(target = "endDate", source = "program.endDate")
        @Mapping(target = "active", source = "program.active")
        ProgramDTO map(HealthProgramEntity program);

        // Null safe mapping for List<HealthProgramEntity> to List<ProgramDTO>
        default List<ProgramDTO> map(List<HealthProgramEntity> programs) {
                if (programs == null) return Collections.emptyList();  // Return an empty list if null
                return programs.stream()
                        .filter(Objects::nonNull)  // Filter out null programs
                        .map(this::map)  // Map the non-null programs to ProgramDTO
                        .collect(Collectors.toList());
        }
}
