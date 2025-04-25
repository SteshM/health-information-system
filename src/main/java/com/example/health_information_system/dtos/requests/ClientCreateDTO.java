package com.example.health_information_system.dtos.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class ClientCreateDTO {
    @NotNull(message = "firstName cannot be null")
    private String firstName;
    @NotNull(message = "lastName cannot be null")
    private String lastName;
    @NotNull(message = "email is required")
    private String email;
    @NotNull(message = "dateOfBirth  cannot be null")
    private LocalDate dateOfBirth;
    @NotNull(message = "gender is required")
    private String gender;
    @NotNull(message = "provide password")
    private String password;
    @NotNull(message = "phoneNumber is required")
    private String phoneNumber;
    private Map<String, String> metaData = new HashMap<>();
}
