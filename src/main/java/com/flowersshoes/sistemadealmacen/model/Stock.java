package com.flowersshoes.sistemadealmacen.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Notations
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idstock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpro")
    private Producto producto;

    private int cantidad;
}
