package com.flowersshoes.sistemadealmacen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_detalle_ingresos")
public class DetalleIngresos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idingre", referencedColumnName = "idingre")
    private Ingresos ingreso;

    @ManyToOne
    @JoinColumn(name = "idpro", referencedColumnName = "idpro")
    private Producto producto;

    private int cantidad;
}
