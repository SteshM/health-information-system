package com.example.health_information_system.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class ProgramEnrolDTO {
    private Long clientId;
    private List<Long> healthProgramIds;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enrollmentDate;
}
