package com.example.health_information_system.models;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="health_program")
@SQLRestriction("deleted_at is null")
public class HealthProgramEntity extends BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long healthProgramId;

        @Column(nullable = false, unique = true)
        private String name;

        private String description;

        private LocalDate startDate;

        private LocalDate endDate;

        private Boolean active = true;

        @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
        private List<ClientProgramEnrollment> enrollments = new ArrayList<>();


}
