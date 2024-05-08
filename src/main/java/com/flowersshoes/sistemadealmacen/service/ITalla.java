package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Talla;

import java.util.List;

public interface ITalla {
    Talla save(Talla talla);
    List<Talla> findAll();
    Talla findById(Integer id);
    boolean existsById(Integer id);
    Talla status(Integer id);
}
