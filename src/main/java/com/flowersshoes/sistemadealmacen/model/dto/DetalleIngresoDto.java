package com.flowersshoes.sistemadealmacen.model.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class DetalleIngresoDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idingre;
    private int idpro;
    private int cantidad;
}
