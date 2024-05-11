package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Ventas;
import com.flowersshoes.sistemadealmacen.model.dto.VentaDto;
import com.flowersshoes.sistemadealmacen.service.impl.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaImpl ventaService;

    @PostMapping("/save")
    public ResponseEntity<String> grabarVenta(@RequestBody VentaDto request) {
        Long idVenta = ventaService.grabarVenta(request.getIdtra(), request.getIdcli());

        if (idVenta != null) {
            return ResponseEntity.ok("Venta creada con ID: " + idVenta);
        } else {
            return ResponseEntity.badRequest().body("Error al crear la venta. El cliente o el trabajador no existen.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarVenta(@PathVariable int id) {
        ventaService.eliminarVenta(id);
    }

    @GetMapping("/listado")
    public List<Object[]> listarVentas() {
        return ventaService.listarVentas();
    }
}
