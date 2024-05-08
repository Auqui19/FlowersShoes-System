package com.flowersshoes.sistemadealmacen.repository;

import com.flowersshoes.sistemadealmacen.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
