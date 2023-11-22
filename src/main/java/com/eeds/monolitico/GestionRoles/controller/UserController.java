package com.eeds.monolitico.GestionRoles.controller;

import com.eeds.monolitico.GestionRoles.input.UserInput;
import com.eeds.monolitico.GestionRoles.model.User;
import com.eeds.monolitico.GestionRoles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<User>> listaUsuarios(){
        return ResponseEntity.ok().body(userService.listarUsuarios());
    }

    @PostMapping
    public ResponseEntity<User> guardar(@RequestBody final UserInput user) throws URISyntaxException {
        User nuevoDb= userService.guardar(user);
        return ResponseEntity.created(new URI("users/"+nuevoDb.getId())).body(nuevoDb);
    }
}
