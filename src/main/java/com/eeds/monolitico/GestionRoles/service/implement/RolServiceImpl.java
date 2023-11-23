package com.eeds.monolitico.GestionRoles.service.implement;

import com.eeds.monolitico.GestionRoles.model.Rol;
import com.eeds.monolitico.GestionRoles.repository.RolRepository;
import com.eeds.monolitico.GestionRoles.service.RolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository userRepository) {
        this.rolRepository = userRepository;
    }

    @Override
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol obtenerRolPorId(Long id) {
        Rol rol= rolRepository.findById(id).orElse(null);
        return rol;
    }

    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol actualizar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void eliminar(Long id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);

        if (rolOptional.isPresent()) {
            Rol rol = rolOptional.get();
            rolRepository.delete(rol);
        } else {
            System.out.println("No se encontró el rol con el id: " + id);
        }

    }
}
