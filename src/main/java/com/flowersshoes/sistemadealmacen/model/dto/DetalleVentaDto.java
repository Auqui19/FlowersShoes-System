package com.flowersshoes.sistemadealmacen.model.dto;

import com.flowersshoes.sistemadealmacen.model.Producto;
import com.flowersshoes.sistemadealmacen.model.Ventas;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaDto {

    private int idventa;
    private int idpro;
    private int cantidad;

    /*
    private double preciouni;
    private double subtotal; */
}
