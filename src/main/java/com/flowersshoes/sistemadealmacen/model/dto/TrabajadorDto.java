package com.flowersshoes.sistemadealmacen.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrabajadorDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtra;
    private String nombres;
    private String nrodocumento;
    private int idrol;
    private String estado;
    private String tipodocumento;
    private String direccion;
    private String email;
    private String password;
}
