package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Talla;
import com.flowersshoes.sistemadealmacen.service.ITalla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/talla/")
public class TallaController {
    @Autowired
    private ITalla tallaService;

    @GetMapping("listado")
    public ResponseEntity<?> listado(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tallaService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("saveTalla")
    public Talla create(@RequestBody Talla talla ){
        return  tallaService.save(talla);
    }


}
