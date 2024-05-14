package com.flowersshoes.sistemadealmacen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcolor;

    @Column(unique = true)
    private String color;

    private String estado;

    @OneToMany(mappedBy = "color" , cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
    @JsonIgnore
    private List<Producto> productos;

}
