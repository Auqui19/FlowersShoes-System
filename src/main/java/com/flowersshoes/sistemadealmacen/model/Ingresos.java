package com.flowersshoes.sistemadealmacen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "tb_ingresos")
public class Ingresos {

    @Id
    private int idingre;
    private String descripcion;
    private String estado;
    private Date fecha;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idtra")
    @JsonManagedReference
    private Trabajador trabajador;
}
