package com.flowersshoes.sistemadealmacen.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpro;
    private String nompro;
    private Double precio;
    private int idtalla;
    private int idcolor;
    private String categoria;
    private String temporada;
    private String descripcion;





}
