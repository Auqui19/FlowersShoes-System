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
@Table(name = "tb_color")
public class Color {
    @Id
    private int idcolor;
    private String color;
    private String estado;

    //@OneToMany(mappedBy = "color" , cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
    //private List<Producto> productos;

}
