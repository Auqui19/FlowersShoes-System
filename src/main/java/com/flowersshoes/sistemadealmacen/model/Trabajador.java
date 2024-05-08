package com.flowersshoes.sistemadealmacen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_trabajador")
public class Trabajador {

    @Id
    private int idtra;
    private String nombres;
    private String nrodocumento;
    private int idrol;
    private String estado;
    private String tipodocumento;
    private String direccion;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "idrol", referencedColumnName = "idrol", insertable = false, updatable = false)
    private Rol rol;

    @OneToMany(mappedBy = "idtra", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ingresos> ingresos;
}
