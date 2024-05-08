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
@Table(name = "tb_producto")
public class Producto {

    //Me salia error , ponieron idproducto pero en la base de datos era idpro
    @Id
    private int idpro;
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

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Stock> stocks;

}
