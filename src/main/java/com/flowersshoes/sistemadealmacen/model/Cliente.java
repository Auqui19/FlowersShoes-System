package com.flowersshoes.sistemadealmacen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int idcli;
    private String nomcli;
    private String apellidos;
    private String tipodocumento;
    private String telefono;
    private String direccion;
    private String nrodocumento;
    private String estado;
}
