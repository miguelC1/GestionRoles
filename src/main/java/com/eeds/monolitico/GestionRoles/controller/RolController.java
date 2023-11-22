package com.eeds.monolitico.GestionRoles.controller;

import com.eeds.monolitico.GestionRoles.model.Rol;
import com.eeds.monolitico.GestionRoles.service.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("rols")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listarRoles() {

        /*List<Rol> roles = rolService.listarRoles();
        return ResponseEntity.ok(roles);*/
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
        /*Rol rol = rolService.obtenerRolPorId(id);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            return ResponseEntity.notFound().build();
        }*/
        return null;
    }

    @PostMapping
    public ResponseEntity<Rol> guardar(@RequestBody Rol rol) {
        /*Rol nuevoRol = rolService.guardar(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);*/
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Rol> actualizar(@RequestBody Rol rol) {
        /*Rol rolActualizado = rolService.actualizarRol(rol);
        if (rolActualizado != null) {
            return ResponseEntity.ok(rolActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }*/
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
      /*  rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();*/
        return null;
    }
}