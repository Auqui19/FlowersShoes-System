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
@Table(name = "tb_producto")
public class Producto {
    @Id
    private int idproducto;
    private String nompro;
    private Double precio;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idtalla" )
    private Talla talla;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idcolor" )
    private Color color;

    private String categoria;
    private String temporada;
    private String descripcion;
    private String estado;
    private String imagen;

}
