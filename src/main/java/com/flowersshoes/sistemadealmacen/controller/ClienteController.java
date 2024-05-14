package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Cliente;
import com.flowersshoes.sistemadealmacen.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @GetMapping("listado")
    public ResponseEntity<?> listado(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }
    @GetMapping("encontrar/{id}")
    public ResponseEntity<?> findbyid(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }
    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Cliente cliente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error. Por favor inténtelo más tarde.\"}");
        }
    }

    @DeleteMapping("status/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.status(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error. Por favor inténtelo más tarde.\"}");
        }
    }
}
