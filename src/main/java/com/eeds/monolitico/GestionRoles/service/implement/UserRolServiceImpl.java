package com.eeds.monolitico.GestionRoles.service.implement;

import com.eeds.monolitico.GestionRoles.dto.UserRolDTO;
import com.eeds.monolitico.GestionRoles.model.Rol;
import com.eeds.monolitico.GestionRoles.model.User;
import com.eeds.monolitico.GestionRoles.model.UserRol;
import com.eeds.monolitico.GestionRoles.repository.UserRolRepository;
import com.eeds.monolitico.GestionRoles.service.RolService;
import com.eeds.monolitico.GestionRoles.service.UserRolService;
import com.eeds.monolitico.GestionRoles.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserRolServiceImpl implements UserRolService {
    private final UserRolRepository userRolRepository;
    private final UserService userService;
    private final RolService rolService;

    public UserRolServiceImpl(UserRolRepository userRolRepository, UserService userService, RolService rolService) {
        this.userRolRepository = userRolRepository;
        this.userService = userService;
        this.rolService = rolService;
    }

    @Override
    public List<UserRol> listarUserRol() {
        return userRolRepository.findAll();
    }

    @Override
    public UserRol guardar(UserRolDTO userRolDTO) {
        User user = userService.obtenerUserPorId(userRolDTO.getUserId());
        Rol rol = rolService.obtenerRolPorId(userRolDTO.getRolId());
        if (user != null && rol != null) {
            UserRol userRol = new UserRol();
            userRol.setUser(user);
            userRol.setRol(rol);
            userRol.setActive(userRolDTO.isActive());
            userRol.setCreatedAt(LocalDateTime.now());

            // Guardar la instancia en la base de datos
            return userRolRepository.save(userRol);
        } else {
            // Manejar el caso en que el User o el Rol no existan
            throw new EntityNotFoundException("No se los ids: " +userRolDTO.getUserId()+" "+userRolDTO.getRolId());
        }
    }


    @Override
    public UserRol inactivarUserRol(Long id) {
        Optional<UserRol> userRolOptional = userRolRepository.findById(id);

        if (userRolOptional.isPresent()) {
            UserRol userRol = userRolOptional.get();
            userRol.setActive(false);
            userRol.setCreatedAt(LocalDateTime.now());
            return userRolRepository.save(userRol);
        } else {
            // Manejo si no se encuentra el UserRol con el ID proporcionado
            throw new EntityNotFoundException("No se encontró el UserRol con ID: " + id);
        }
    }


    @Override
    public List<UserRol> asignarRoles(Long userId, List<Long> rolesIds) {
        List<UserRol> list= new ArrayList<>();
        User user = userService.obtenerUserPorId(userId);
        List<Rol> roles= new ArrayList<>();
        rolesIds.forEach(x -> {
            Rol rol= rolService.obtenerRolPorId(x);
            roles.add(rol);
        });

        roles.forEach(x -> {
            UserRol userRol = new UserRol();
            userRol.setUser(user);
            userRol.setRol(x);
            userRol.setActive(true);
            userRol.setCreatedAt(LocalDateTime.now());

            userRolRepository.save(userRol);
            list.add(userRol);
        });

        return list;
    }

}
