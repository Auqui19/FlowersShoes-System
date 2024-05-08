package com.flowersshoes.sistemadealmacen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpro;
    private String codbar;
    private String imagen;
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


    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Stock> stocks;

}
