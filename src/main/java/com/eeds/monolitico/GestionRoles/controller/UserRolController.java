package com.eeds.monolitico.GestionRoles.controller;

import com.eeds.monolitico.GestionRoles.dto.UserRolDTO;
import com.eeds.monolitico.GestionRoles.model.UserRol;
import com.eeds.monolitico.GestionRoles.service.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user_rols")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;

    }
    @PostMapping()
    public ResponseEntity<UserRol> guardar(@RequestBody UserRolDTO userRolDTO) {
        UserRol newUserRol = userRolService.guardar(userRolDTO);

        if (newUserRol != null) {
            return ResponseEntity.ok(newUserRol);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<UserRol> inactivarUserRol(@PathVariable Long id) {
        UserRol userRol = userRolService.inactivarUserRol(id);
        return ResponseEntity.ok(userRol);
    }

}

