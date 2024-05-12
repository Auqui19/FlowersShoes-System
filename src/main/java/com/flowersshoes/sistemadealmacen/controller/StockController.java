package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.service.impl.StockImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockImpl stockService;

    @GetMapping("listado")
    public ResponseEntity<?> listado(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(stockService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("encontrar/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(stockService.findById(id));
        } catch (DataAccessException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }
}
