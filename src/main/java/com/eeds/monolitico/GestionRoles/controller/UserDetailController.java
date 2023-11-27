package com.eeds.monolitico.GestionRoles.controller;


import com.eeds.monolitico.GestionRoles.model.User;
import com.eeds.monolitico.GestionRoles.model.UserDetail;
import com.eeds.monolitico.GestionRoles.service.UserDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user_details")
public class UserDetailController {
    private  final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetail> obtenerUserPorId(@PathVariable Long id) {
        UserDetail userDetail = userDetailService.obtenerUserDetalle(id);
        if (userDetail != null) {
            return ResponseEntity.ok(userDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
