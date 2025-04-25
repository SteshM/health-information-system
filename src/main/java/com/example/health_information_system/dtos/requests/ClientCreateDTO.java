package com.example.health_information_system.dtos.requests;

import jakarta.persistence.Column;
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
    private Long clientId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private String password;
    private String phoneNumber;
    private Map<String, String> metaData = new HashMap<>();
}
