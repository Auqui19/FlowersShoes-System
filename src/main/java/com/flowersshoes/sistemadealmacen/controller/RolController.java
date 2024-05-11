package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Rol;
import com.flowersshoes.sistemadealmacen.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rol/")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RolController {
    @Autowired
    private IRolService iRolService;

    @GetMapping("listado")
    public ResponseEntity<?> listado(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(iRolService.findAll());
        } catch (DataAccessException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("encontrar/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(iRolService.findById(id));
        } catch (DataAccessException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Rol rol) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iRolService.save(rol));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                    .body("{\"error\":\"Error. Por favor inténtelo más tarde.\"}");
        }
    }

    @DeleteMapping("status/{id}")
    public ResponseEntity<?> status(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(iRolService.status(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }
}
