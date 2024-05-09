package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Rol;
import com.flowersshoes.sistemadealmacen.repository.RolRepository;
import com.flowersshoes.sistemadealmacen.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolImpl implements IRolService {

    @Autowired
    private RolRepository rolRepository;

    @Transactional
    @Override
    public Rol save(Rol rol) {
        rol.setEstado("Activo");
        return rolRepository.save(rol);
    }

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    public Rol findById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Integer id) {
        return rolRepository.existsById(id);
    }

    @Override
    public Rol status(Integer id) {
        Rol rol = rolRepository.findById(id).orElse(null);
        if (rol != null) {
            if (rol.getEstado().equals("Activo")) {
                rol.setEstado("Inactivo");
            } else {
                rol.setEstado("Activo");
            }
            return rolRepository.save(rol);
        }
        return null;
    }
}
