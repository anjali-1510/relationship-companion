package com.anjali.relationshipcompanion.dto;

import java.time.LocalDate;

public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String gender;
    private LocalDate dateOfBirth;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, String email,
                        String gender, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}