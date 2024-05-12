package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.dto.DetalleVentaDto;
import com.flowersshoes.sistemadealmacen.service.impl.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalleVenta")
public class DetalleVentaController {

    @Autowired
    private VentaImpl ventaDetaService;

    @PostMapping("/grabar")
    public ResponseEntity<?> grabarDetalleVenta(@RequestBody DetalleVentaDto request) {
        try {
            return ResponseEntity.status(200).body(ventaDetaService.grabarDetalleVenta(
                    request.getIdventa(),
                    request.getIdpro(),
                    request.getCantidad()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error. Por favor inténtelo más tarde.+ " + e.getMessage() + "}");
        }
    }

    @DeleteMapping("/eliminar/{idventa}/detalles/{idpro}/{cantidad}")
    public void eliminarDetalleVenta(@PathVariable int idventa, @PathVariable int idpro, @PathVariable int cantidad) {
        ventaDetaService.eliminarDetalleVenta(idpro, cantidad);
    }

    @PutMapping("/restaurar/{idpro}/restaurar")
    public void restaurarDetalleVenta(@PathVariable int idpro, @RequestParam int cantidad) {
        ventaDetaService.restaurarDetalleVenta(idpro, cantidad);
    }

    @GetMapping("/ventas/{idventa}/detalle")
    public List<Object[]> listarDetalleVentas(@PathVariable int idventa) {
        return ventaDetaService.listarDetalleVentas(idventa);
    }
}
