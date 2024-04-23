package com.flowersshoes.sistemadealmacen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.management.ConstructorParameters;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_ingresos")
public class Ingresos {

    @Id
    private int idIngre;
    private Date fecha;
    private String descripcion;
    private String estado;
    private int idTra;
}
