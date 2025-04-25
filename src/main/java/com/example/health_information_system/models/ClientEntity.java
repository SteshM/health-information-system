package com.example.health_information_system.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="client")
@SQLRestriction("deleted_at is null")
public class ClientEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private String password;
    private String phoneNumber;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> metaData = new HashMap<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientProgramEnrollment> enrollments = new ArrayList<>();


}
