package com.example.health_information_system.mappers;
import com.example.health_information_system.dtos.requests.HealthProgramCreateDTO;
import com.example.health_information_system.dtos.responses.ProgramDTO;
import com.example.health_information_system.models.HealthProgramEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HealthProgramMapper {
    ProgramDTO map(HealthProgramEntity entity);

    @Mapping(target = "healthProgramID", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "startDate", ignore = true)
    @Mapping(target = "endDate", ignore = true)
    @Mapping(target = "active", ignore = true)
    HealthProgramEntity map(HealthProgramCreateDTO entity);
}
