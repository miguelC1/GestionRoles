package com.eeds.monolitico.GestionRoles.service.implement;

import com.eeds.monolitico.GestionRoles.model.UserRol;
import com.eeds.monolitico.GestionRoles.repository.UserRolRepository;
import com.eeds.monolitico.GestionRoles.service.UserRolService;
import jakarta.transaction.Transactional;

import java.util.List;

public class UserRolServiceImpl implements UserRolService {
    private final UserRolRepository userRolRepository;

    public UserRolServiceImpl(UserRolRepository userRolRepository) {
        this.userRolRepository = userRolRepository;
    }

    @Override
    public List<UserRol> listarUserRol() {
        return userRolRepository.findAll();
    }

    @Override
    public UserRol guardar(UserRol userRol) {
        return userRolRepository.save(userRol);
    }

    @Override
    public UserRol actualizarEstado(Long id, boolean activo) {
        /*UserRol userRol = userRolRepository.findById(id)
                .orElseThrow(() -> new UserRolNotFoundException("UserRol no encontrado"));

        userRol.setActive(activo);

        // Guarda y devuelve el UserRol actualizado
        return userRolRepository.save(userRol);*/
        return null;
    }
}
