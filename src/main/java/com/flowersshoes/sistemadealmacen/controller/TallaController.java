package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Talla;
import com.flowersshoes.sistemadealmacen.service.ITalla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/talla/")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("encontrar/{id}")
    public ResponseEntity<?> findbyid(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tallaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Talla talla) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tallaService.save(talla));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error. Por favor inténtelo más tarde.\"}");
        }
    }
    @DeleteMapping("status/{id}")
    public ResponseEntity<?> status(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tallaService.status(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }


}
