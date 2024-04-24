package com.flowersshoes.sistemadealmacen.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Notations
@Data //Parte de Lombok agrega auto "To string", "equals", "hashcode", "Get and Set" ayuda a reducir code
@NoArgsConstructor //Parte de Lombok crea un constructor sin argumentos para la clase
@AllArgsConstructor //Parte de Lombok crea un constructor con todos los argumentos
@ToString //Genera auto el metodo "ToString"
@Entity //Marca la clase como entidad, representa una tabla de la base de datos
@Table(name = "tb_stock")
public class Stock {
    @Id
    private int idstock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpro")
    private Producto producto;

    private int cantidad;
}
