package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Color;
import com.flowersshoes.sistemadealmacen.model.Talla;
import com.flowersshoes.sistemadealmacen.service.IColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/color/")
public class ColorController {

    @Autowired
    private IColor colorService;

    @GetMapping("listado")
    public ResponseEntity<?> listado(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(colorService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Color color) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(colorService.save(color));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error. Por favor inténtelo más tarde.\"}");
        }
    }

}