package com.flowersshoes.sistemadealmacen.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tb_ingresos")
public class Ingresos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idingre;
    private String descripcion;
    private String estado;
    private Date fecha;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idtra")
    private Trabajador trabajador;



}
