package com.flowersshoes.sistemadealmacen.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaDto {

    private int idventa;
    private int idpro;
    private String imagen;
    private String nompro;
    private String color;
    private String talla;
    private int cantidad;
    private double preciouni;
    private double subtotal;
}
