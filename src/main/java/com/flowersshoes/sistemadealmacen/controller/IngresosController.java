package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Ingresos;
import com.flowersshoes.sistemadealmacen.service.IIngresos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class IngresosController {

    @Autowired
    private IIngresos ingresosService;

    @PostMapping("ingreso")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingresos create(@RequestBody Ingresos ingresos){
        return ingresosService.save(ingresos);
    }

    @PutMapping("ingreso")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingresos update(@RequestBody Ingresos ingresos){
        return ingresosService.save(ingresos);
    }

    @DeleteMapping("ingreso/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        Ingresos ingresosDelete = ingresosService.findById(id);
        ingresosService.delete(ingresosDelete);
    }

    @GetMapping("ingreso/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ingresos showById(@PathVariable Integer id){
        return ingresosService.findById(id);
    }
}
