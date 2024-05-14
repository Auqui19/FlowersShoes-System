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
@Table(name = "tb_talla")
public class Talla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtalla;
    @Column(unique = true)
    private String talla;
    private String estado;

    @OneToMany(mappedBy = "talla" , cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
    @JsonIgnore
    private List<Producto> productos;

}
