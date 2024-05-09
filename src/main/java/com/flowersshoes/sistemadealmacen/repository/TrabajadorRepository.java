package com.flowersshoes.sistemadealmacen.repository;

import com.flowersshoes.sistemadealmacen.model.Trabajador;
import org.springframework.data.repository.CrudRepository;

public interface TrabajadorRepository extends CrudRepository<Trabajador, Integer> {
    Trabajador findByEmail(String email);
}
