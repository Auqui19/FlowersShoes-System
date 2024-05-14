package com.flowersshoes.sistemadealmacen.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.flowersshoes.sistemadealmacen.model.Trabajador;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngresosDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idingre;
    private int idtra;
    private String nomtra;
    private String descripcion;
    private String estado;
    private Date fecha;


    List<DetalleIngresoDto> detalles;

}
