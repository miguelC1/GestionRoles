package com.eeds.monolitico.GestionRoles.service.implement;

import com.eeds.monolitico.GestionRoles.dto.UserDTO;
import com.eeds.monolitico.GestionRoles.dto.UserDetalleDTO;
import com.eeds.monolitico.GestionRoles.input.UserInput;
import com.eeds.monolitico.GestionRoles.model.Rol;
import com.eeds.monolitico.GestionRoles.model.User;
import com.eeds.monolitico.GestionRoles.model.UserDetail;
import com.eeds.monolitico.GestionRoles.model.UserRol;
import com.eeds.monolitico.GestionRoles.repository.RolRepository;
import com.eeds.monolitico.GestionRoles.repository.UserDetailRepository;
import com.eeds.monolitico.GestionRoles.repository.UserRepository;
import com.eeds.monolitico.GestionRoles.service.Exception.RolNotFoundException;
import com.eeds.monolitico.GestionRoles.service.Exception.UserNotFoundException;
import com.eeds.monolitico.GestionRoles.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;

    public UserServiceImpl(UserRepository userRepository, UserDetailRepository userDetailRepository, RolRepository rolRepository) {
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
        nuevo.setCreatedAt(LocalDateTime.now());
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

    @Override
    public User obtenerUserPorId(Long id) {
        Optional<User> user= userRepository.findById(id);
        return user.get();
    }

    @Override
    public User actualizar(User user) {
        return userRepository.save(user);
    }

    @Override
    public void eliminar(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
        } else {
            System.out.println("No se encontró el rol con el id: " + id);
        }

    }

    public List<UserDTO> listarNormal() {
        List<Object[]> resultList = userRepository.listarUsuarioNormal();

        return resultList.stream()
                .map(this::mapObjectArrayToUserDTO)
                .collect(Collectors.toList());
    }

    private UserDTO mapObjectArrayToUserDTO(Object[] obj) {
        UserDTO dto = new UserDTO();
        dto.setUsername(String.valueOf(obj[0]));
        dto.setEmail(String.valueOf(obj[1]));

        String fechaString = String.valueOf(obj[2]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n");
        LocalDateTime fecha = LocalDateTime.parse(fechaString, formatter);
        dto.setCreatedAt(fecha);

        return dto;
    }

    public List<UserDetalleDTO> listarDetallado(){
        List<Object[]> list= userRepository.listarDetallado();

        return list.stream()
                .map(this::mapObjectArrayToUserDetalleDTO)
                .collect(Collectors.toList());
    }

    private UserDetalleDTO mapObjectArrayToUserDetalleDTO(Object[] obj){
        UserDetalleDTO dto= new UserDetalleDTO();
        dto.setUsername(String.valueOf(obj[0]));
        dto.setEmail(String.valueOf(obj[1]));

        String fechaString = String.valueOf(obj[2]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n");
        LocalDateTime fecha = LocalDateTime.parse(fechaString, formatter);
        dto.setCreatedAt(fecha);

        dto.setFirstName(String.valueOf(obj[3]));
        dto.setLastName(String.valueOf(obj[4]));
        dto.setAge(Integer.parseInt(String.valueOf(obj[5])));
        dto.setBirthDay(String.valueOf(obj[6]));

        return dto;
    }

}
