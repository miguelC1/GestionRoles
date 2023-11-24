package com.eeds.monolitico.GestionRoles.service.Exception;

public class RolNotFoundException extends RuntimeException{
    public RolNotFoundException(String message) {
        super(message);
    }
}