package com.flowersshoes.sistemadealmacen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcli;
    private String nomcli;
    private String apellidos;
    private String tipodocumento;
    private String telefono;
    private String direccion;
    private String nrodocumento;
    private String estado;
}
