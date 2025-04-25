package com.example.health_information_system.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class ClientProfileDTO {
    private Long clientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private Map<String, String> metaData = new HashMap<>();
    private List<ProgramDTO> enrolledPrograms; // This is the list of enrolled programs
}
