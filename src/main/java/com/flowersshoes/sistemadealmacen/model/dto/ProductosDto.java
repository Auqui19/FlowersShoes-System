package com.flowersshoes.sistemadealmacen.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flowersshoes.sistemadealmacen.model.Color;
import com.flowersshoes.sistemadealmacen.model.Stock;
import com.flowersshoes.sistemadealmacen.model.Talla;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
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
