package com.example.health_information_system.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class ProgramDTO {
    private Long healthProgramId;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean active;
}
