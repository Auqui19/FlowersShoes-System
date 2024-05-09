package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Ventas;
import com.flowersshoes.sistemadealmacen.model.dto.VentaDto;

public interface IVenta {

    Ventas save(VentaDto ventaDto); //guardar una venta

    Ventas findById(Integer id); //buscar por id

    void delete(Ventas venta); //eliminar una venta

    Iterable<Ventas> findAll(); //listar todas las ventas realizadas

    boolean existsById(Integer id); //buscar si es que existe o no una venta con ese id
}
