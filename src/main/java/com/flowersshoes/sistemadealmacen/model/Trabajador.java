package com.flowersshoes.sistemadealmacen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tb_trabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtra;
    private String nombres;
    private String tipodocumento;
    @Column(unique = true)
    private String nrodocumento;
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "idrol")
    private Rol rol;

    @Column(unique = true)
    private String email;
    private String password;
    private String estado;

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ingresos> ingresos;




}
