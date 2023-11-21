package com.eeds.monolitico.GestionRoles.service.implement;

import com.eeds.monolitico.GestionRoles.model.User;
import com.eeds.monolitico.GestionRoles.repository.UserRepository;
import com.eeds.monolitico.GestionRoles.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listaUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
