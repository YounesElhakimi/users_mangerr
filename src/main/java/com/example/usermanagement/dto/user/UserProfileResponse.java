package com.example.usermanagement.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String profileImageUrl;
    private boolean active;
    private boolean emailVerified;
    private boolean phoneVerified;
    private Set<String> roles;
    private OffsetDateTime createdAt;
    private OffsetDateTime lastLoginAt;
} 