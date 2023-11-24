package com.eeds.monolitico.GestionRoles.dto;

import jakarta.persistence.Column;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserDTO {

    private String username;
    private String email;
    private LocalDateTime createdAt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime  getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime  createdAt) {
        this.createdAt = createdAt;
    }
}
