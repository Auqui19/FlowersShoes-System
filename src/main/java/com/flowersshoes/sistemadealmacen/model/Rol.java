package com.flowersshoes.sistemadealmacen.model;

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
@Table(name = "tb_rol")
public class Rol {

    @Id
    private int idrol;
    private String nomrol;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<Trabajador> trabajadores;
}
