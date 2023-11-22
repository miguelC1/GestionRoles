package com.eeds.monolitico.GestionRoles.service.implement;

import com.eeds.monolitico.GestionRoles.model.UserDetail;
import com.eeds.monolitico.GestionRoles.repository.UserDetailRepository;
import com.eeds.monolitico.GestionRoles.service.UserDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public List<UserDetail> listarUsuarioDetails() {

        return userDetailRepository.findAll();
    }

    @Override
    public UserDetail guardar(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }
}
