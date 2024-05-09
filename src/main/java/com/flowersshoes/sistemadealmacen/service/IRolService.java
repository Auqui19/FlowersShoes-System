package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Rol;

import java.util.List;

public interface IRolService {
    Rol save(Rol rol);

    List<Rol> findAll();

    Rol findById(Integer id);

    boolean existsById(Integer id);

    Rol status(Integer id);
}
