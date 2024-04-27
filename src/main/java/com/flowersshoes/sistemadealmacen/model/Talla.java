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
@Table(name = "tb_talla")
public class Talla {
    @Id
    private int idtalla;
    private String talla;
    private String estado;

    //@OneToMany(mappedBy = "talla" , cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
    //private List<Producto> productos;

}
