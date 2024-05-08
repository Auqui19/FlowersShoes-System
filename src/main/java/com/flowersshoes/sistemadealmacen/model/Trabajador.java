package com.flowersshoes.sistemadealmacen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_trabajador")
@JsonIgnoreProperties("ingresos")
public class Trabajador {

    @Id
    private Integer idtra;
    private String nombres;
    private String nrodocumento;

    @ManyToOne
    @JoinColumn(name = "idrol", referencedColumnName = "idrol", insertable = false, updatable = false)
    private Rol idrol;
    private int estado;
    private String tipodocumento;
    private String direccion;
    private String email;
    private String password;

    @OneToMany(mappedBy = "idtra", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ingresos> ingresos = new ArrayList<>();
}
