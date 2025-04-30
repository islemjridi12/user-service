package com.example.userservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "app_user")
public class User {
    public enum Role {
        ADMIN,
        VISITEUR
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomETprenom;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
}

