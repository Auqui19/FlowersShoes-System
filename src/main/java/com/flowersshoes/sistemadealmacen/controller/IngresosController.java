package com.flowersshoes.sistemadealmacen.controller;
import com.flowersshoes.sistemadealmacen.model.dto.IngresosDto;
import com.flowersshoes.sistemadealmacen.repository.IngresosRepository;
import com.flowersshoes.sistemadealmacen.service.impl.IngresosImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ingresos")
@CrossOrigin(origins = "http://localhost:4200")
public class IngresosController {

    @Autowired
    private IngresosImpl ingresosService;

    @Autowired
    private IngresosRepository ingresosRepository;

    @GetMapping("/listado")
    public ResponseEntity<?> ListarIngresos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ingresosService.listarIngresos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> grabarIngreso(@RequestBody IngresosDto request) {


        if (request.getDescripcion() != null) {
            int idIngreso = ingresosService.grabarIngreso(request.getIdtra(), request.getDescripcion(), request.getDetalles());
            return ResponseEntity.ok("Ingreso creado con ID: " + idIngreso);
        } else {
            return ResponseEntity.badRequest().body("Error al crear el ingreso. El el trabajador no existe.");
        }
    }

}






































