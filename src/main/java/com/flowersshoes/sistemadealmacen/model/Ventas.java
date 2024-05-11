package com.flowersshoes.sistemadealmacen.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idventa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idtra")
    private Trabajador trabajador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcli")
    private Cliente cliente;

    private Date fecha;
    private Double total;
    private String estado;
    private String estadocomprobante;

}
