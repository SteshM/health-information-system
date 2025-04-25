package com.example.health_information_system.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class ProgramEnrolDTO {
    @NotNull(message = "clientId is required")
    private Long clientId;
    @NotNull(message = "This field cannot be null")
    private List<Long> healthProgramIds;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enrollmentDate;
}
