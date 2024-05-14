package com.flowersshoes.sistemadealmacen.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idventa;
    private int idtra;
    private String nomtra;
    private int idcli;
    private String nomcli;
    private Date fecha;
    private double total;
    private String estadocomprobante;
    private String estado;

    List<DetalleVentaDto> detalles;
}
