package com.eeds.monolitico.GestionRoles.controller;

import com.eeds.monolitico.GestionRoles.dto.UserDTO;
import com.eeds.monolitico.GestionRoles.dto.UserDetalleDTO;
import com.eeds.monolitico.GestionRoles.input.UserInput;
import com.eeds.monolitico.GestionRoles.model.Rol;
import com.eeds.monolitico.GestionRoles.model.User;
import com.eeds.monolitico.GestionRoles.service.UserService;
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
        try{
            User nuevoDb= userService.guardar(user);
            return ResponseEntity.created(new URI("users/"+nuevoDb.getId())).body(nuevoDb);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/listarNormal")
    public ResponseEntity<List<UserDTO>> listarNormal(){
        List<UserDTO> list= userService.listarNormal();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<User> editar(@PathVariable Long id,@RequestBody UserInput user) {
        try{
            User userActualizado = userService.editar(id,user);
            if (userActualizado != null) {
                return ResponseEntity.ok(userActualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> obtenerUserPorId(@PathVariable Long id) {
        User user = userService.obtenerUserPorId(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/detallado/{id}")
    public ResponseEntity<UserInput> obtenerUserDetalladoPorId(@PathVariable Long id) {
        UserInput user = userService.obtenerUserDetalladoPorId(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            userService.eliminar(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarDetallado")
    public ResponseEntity<List<UserDetalleDTO>> listarDetallado(){
        List<UserDetalleDTO> list= userService.listarDetallado();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
