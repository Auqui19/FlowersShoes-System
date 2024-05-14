package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Ingresos;
import com.flowersshoes.sistemadealmacen.model.dto.DetalleIngresoDto;
import com.flowersshoes.sistemadealmacen.model.dto.IngresosDto;
import com.flowersshoes.sistemadealmacen.model.dto.VentaDto;
import com.flowersshoes.sistemadealmacen.model.payload.MensajeResponse;
import com.flowersshoes.sistemadealmacen.repository.IngresosRepository;
import com.flowersshoes.sistemadealmacen.service.impl.IngresosImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ingresos")
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






































/**
    @GetMapping("/listado")
    public ResponseEntity<?> listado(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ingresosService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    // Borrar si es posible
    @GetMapping("/ingreso")
    public ResponseEntity<?> showAll() {
        Iterable<Ingresos> ingresos = ingresosService.findAll();

        if (!ingresos.iterator().hasNext()) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay ingresos registrados")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }

        List<IngresosDto> ingresosDtoList = new ArrayList<>();
        for (Ingresos ingreso : ingresos) {
            ingresosDtoList.add(IngresosDto.builder()
                    .idingre(ingreso.getIdingre())
                    .descripcion(ingreso.getDescripcion())
                    .estado(ingreso.getEstado())
                    .fecha(ingreso.getFecha())
                    .build());
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Consulta Exitosa")
                        .object(ingresosDtoList)
                        .build(),
                HttpStatus.OK);
    }

    @PostMapping("/ingreso")
    public ResponseEntity<?> create(@RequestBody IngresosDto ingresosDto){
        Ingresos ingresosSave = null;
        try {
            ingresosSave = ingresosService.save(ingresosDto);
            ingresosDto = IngresosDto.builder()
                    .idingre(ingresosSave.getIdingre())
                    .descripcion(ingresosSave.getDescripcion())
                    .estado(ingresosSave.getEstado())
                    .fecha(ingresosSave.getFecha())
                    .build();

            return new ResponseEntity<>( MensajeResponse.builder()
                    .mensaje("Ingreso guardado correctamente")
                    .object(ingresosDto)
                    .build()
                    ,HttpStatus.CREATED);
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("/ingreso/{id}")
    public ResponseEntity<?> update(@RequestBody IngresosDto ingresosDto, @PathVariable Integer id){
        Ingresos ingresosUpdate = null;
        try {
            if (ingresosService.existsById(id)){
                ingresosDto.setIdingre(id);
                ingresosUpdate = ingresosService.save(ingresosDto);
                ingresosDto = IngresosDto.builder()
                        .idingre(ingresosUpdate.getIdingre())
                        .descripcion(ingresosUpdate.getDescripcion())
                        .estado(ingresosUpdate.getEstado())
                        .fecha(ingresosUpdate.getFecha())
                        .build();

                return new ResponseEntity<>( MensajeResponse.builder()
                        .mensaje("Ingreso actualizado correctamente")
                        .object(ingresosDto)
                        .build()
                        ,HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("El ingresos no se encuentra.")
                                .object(null)
                                .build()
                        ,HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("/ingreso/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            Ingresos ingresosDelete = ingresosService.findById(id);
            ingresosService.delete(ingresosDelete);
            return new ResponseEntity<>(ingresosDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                        .mensaje(exDt.getMessage())
                        .object(null)
                        .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("/ingreso/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id){
        Ingresos ingresos = ingresosService.findById(id);
        if(ingresos == null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El registro no exite!!")
                            .object(null)
                            .build()
                    ,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Consulta Exitosa")
                        .object(IngresosDto.builder()
                                .idingre(ingresos.getIdingre())
                                .descripcion(ingresos.getDescripcion())
                                .estado(ingresos.getEstado())
                                .fecha(ingresos.getFecha())
                                .build())
                        .build()
                ,HttpStatus.OK);
    }
}
**/