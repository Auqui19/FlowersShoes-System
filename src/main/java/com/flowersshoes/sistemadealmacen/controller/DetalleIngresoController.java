package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.dto.DetalleIngresoDto;
import com.flowersshoes.sistemadealmacen.service.impl.DetalleIngresosImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalleIngreso")
public class DetalleIngresoController {

    @Autowired
    private DetalleIngresosImpl ingresoDetaService;

    @PostMapping("/grabar")
    public void grabarDetalleIngreso(@RequestBody DetalleIngresoDto request) {
        ingresoDetaService.grabarDetalleIngreso(request.getIdingre(), request.getIdpro(), request.getCantidad());
    }
}
