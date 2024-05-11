package com.flowersshoes.sistemadealmacen.model.dto;

import com.flowersshoes.sistemadealmacen.model.Producto;
import com.flowersshoes.sistemadealmacen.model.Ventas;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class DetalleVentaDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idventa;
    private int idpro;
    private int cantidad;
    private double preciouni;
    private double subtotal;
}
