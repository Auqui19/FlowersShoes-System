package com.flowersshoes.sistemadealmacen.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.flowersshoes.sistemadealmacen.model.Trabajador;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class IngresosDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idingre;
    private String descripcion;
    private String estado;
    private Date fecha;
    private int idtra;
}
