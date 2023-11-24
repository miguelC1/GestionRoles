package com.eeds.monolitico.GestionRoles.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class UserRolDTO {
    private boolean active;
    private Long userId;
    private Long rolId;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }
}
