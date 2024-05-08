package com.flowersshoes.sistemadealmacen.repository;

import com.flowersshoes.sistemadealmacen.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<Producto,Integer> {

}
