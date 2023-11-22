package com.eeds.monolitico.GestionRoles.service.implement;

import com.eeds.monolitico.GestionRoles.input.UserInput;
import com.eeds.monolitico.GestionRoles.model.User;
import com.eeds.monolitico.GestionRoles.model.UserDetail;
import com.eeds.monolitico.GestionRoles.repository.UserDetailRepository;
import com.eeds.monolitico.GestionRoles.repository.UserRepository;
import com.eeds.monolitico.GestionRoles.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;

    public UserServiceImpl(UserRepository userRepository, UserDetailRepository userDetailRepository) {
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public List<User> listarUsuarios() {
        List<User> lista= userRepository.findAll();
        return lista;
    }

    @Override
    public User guardar(UserInput user) {
        User nuevo=new User();
        nuevo.setUsername(user.getUsername());
        nuevo.setPassword(user.getPassword());
        nuevo.setEmail(user.getEmail());
        nuevo.setCreated_at(user.getCreatedAt());
        nuevo=userRepository.save(nuevo);

        UserDetail userDetail= new UserDetail();
        userDetail.setUser(nuevo);
        userDetail.setFirstName(user.getFirstName());
        userDetail.setLastName(user.getLastName());
        userDetail.setAge(user.getAge());
        userDetail.setBirthDay(user.getBirthDay());
        userDetailRepository.save(userDetail);
        return nuevo;
    }
}
