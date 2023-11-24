package com.eeds.monolitico.GestionRoles.service;

import com.eeds.monolitico.GestionRoles.model.UserDetail;

import java.util.List;

public interface UserDetailService {
    List<UserDetail> listarUsuarioDetails();

    UserDetail guardar(UserDetail userDetail);

}
