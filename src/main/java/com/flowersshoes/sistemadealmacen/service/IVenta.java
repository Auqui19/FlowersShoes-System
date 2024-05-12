package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.DetalleVenta;
import com.flowersshoes.sistemadealmacen.model.Ventas;
import com.flowersshoes.sistemadealmacen.model.dto.VentaDto;

import java.util.List;

public interface IVenta {

    Ventas findById(Integer id);
    List<Ventas> findAll();
    List<DetalleVenta> listarDetalleVentas();
}
