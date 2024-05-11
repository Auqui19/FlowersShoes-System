package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.dto.DetalleVentaDto;
import com.flowersshoes.sistemadealmacen.service.impl.VentaDetalleImpl;
import com.flowersshoes.sistemadealmacen.service.impl.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/detalleVenta")
public class DetalleVentaController {

    @Autowired
    private VentaDetalleImpl ventaDetaService;

    @PostMapping("/grabar")
    public void grabarDetalleVenta(@RequestBody DetalleVentaDto request) {
        int idventa = request.getIdventa();
        int idpro = request.getIdpro();
        int cantidad = request.getCantidad();
        BigDecimal precioUni = BigDecimal.valueOf(request.getPreciouni());
        BigDecimal subtotal = BigDecimal.valueOf(request.getSubtotal());

        ventaDetaService.grabarDetalleVenta(idventa, idpro, cantidad, precioUni, subtotal);
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
