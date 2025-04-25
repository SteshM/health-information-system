package com.example.health_information_system.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class HealthProgramCreateDTO {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
