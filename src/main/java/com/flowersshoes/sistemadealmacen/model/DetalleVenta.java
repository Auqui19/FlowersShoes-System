package com.flowersshoes.sistemadealmacen.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idventa")
    private Ventas idventa;

    @ManyToOne
    @JoinColumn(name = "idpro")
    private Producto idproducto;

    private int cantidad;
    private double preciouni;
    private double subtotal;
}

