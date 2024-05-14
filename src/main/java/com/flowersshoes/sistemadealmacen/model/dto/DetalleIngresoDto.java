package com.flowersshoes.sistemadealmacen.model.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleIngresoDto {

    private int idingre;
    private int idpro;
    private String imagen;
    private String nompro;
    private String color;
    private String talla;
    private int cantidad;

}
