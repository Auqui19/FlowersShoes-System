package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Producto;
import com.flowersshoes.sistemadealmacen.model.dto.ProductosDto;

import java.util.List;

public interface IProducto {
    Producto save(ProductosDto productoDto);
    List<Producto> findAll();
    Producto findById(Integer id);
    boolean existsById(Integer id);
    Producto status(Integer id);
}
