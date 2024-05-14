package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Ventas;
import com.flowersshoes.sistemadealmacen.model.dto.VentaDto;
import com.flowersshoes.sistemadealmacen.service.impl.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaController {

    @Autowired
    private VentaImpl ventaService;

    @GetMapping("/listado")
    public ResponseEntity<?> ListarIngresos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ventaService.listarVentas());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> grabarVenta(@RequestBody VentaDto request) {
        int idVenta = ventaService.grabarVenta(request.getIdtra(), request.getIdcli(), request.getDetalles());

        if (idVenta != 0) {
            return ResponseEntity.ok("Venta creada con ID: " + idVenta);
        } else {
            return ResponseEntity.badRequest().body("Error al crear la venta. El cliente o el trabajador no existen.");
        }
    }



}
