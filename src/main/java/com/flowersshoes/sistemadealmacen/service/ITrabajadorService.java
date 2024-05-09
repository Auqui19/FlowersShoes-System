package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Trabajador;
import com.flowersshoes.sistemadealmacen.model.dto.TrabajadorDto;

import java.util.List;

public interface ITrabajadorService {

    Trabajador save(TrabajadorDto trabajadorDto);

    List<Trabajador> findAll();

    Trabajador findById(Integer id);

    boolean existsById(Integer id);

    Trabajador status(Integer id);
}
