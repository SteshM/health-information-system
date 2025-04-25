package com.example.health_information_system.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class HealthProgramCreateDTO {
    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "description cannot be null")
    private String description;
    @NotNull(message = "startDate cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @NotNull(message = "endDate cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
