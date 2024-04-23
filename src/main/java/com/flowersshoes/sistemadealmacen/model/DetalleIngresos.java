package com.flowersshoes.sistemadealmacen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "idingre")
    private int idIngre;
    private int idPro;
    private int cantidad;
}
