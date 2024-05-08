package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Ingresos;
import com.flowersshoes.sistemadealmacen.model.Trabajador;
import com.flowersshoes.sistemadealmacen.model.dto.IngresosDto;
import com.flowersshoes.sistemadealmacen.model.payload.MensajeResponse;
import com.flowersshoes.sistemadealmacen.repository.IngresosRepository;
import com.flowersshoes.sistemadealmacen.repository.TrabajadorRepository;
import com.flowersshoes.sistemadealmacen.response.ingresos.IngresoResponse;
import com.flowersshoes.sistemadealmacen.service.IIngresos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingresos")
public class IngresosController {

    @Autowired
    private IIngresos ingresosService;

    @Autowired
    private IngresosRepository ingresosRepository;

    @Autowired
    private TrabajadorRepository trabajadorRespository;

    @PostMapping("/add")
    public IngresoResponse addIngreso(@RequestBody Ingresos ingreso){
        if(ingreso.getIdingre() != null){
            return new IngresoResponse("99", "Id parameter not allowed");
        }
        Trabajador trabajador = ingreso.getIdtra();
        // Obtener el ID del trabajador del objeto Ingresos
        Integer idTraId = trabajador.getIdtra();
        // Buscar el trabajador en la base de datos por su ID
        Optional<Trabajador> trabajadorOptional = trabajadorRespository.findById(idTraId);
        // Verificar si se encontró el trabajador
        if (trabajadorOptional.isPresent()) {
            // Asignar el trabajador al objeto Ingresos
            ingreso.setIdtra(trabajadorOptional.get());
            // Guardar el ingreso en la base de datos
            ingresosRepository.save(ingreso);
            return new IngresoResponse("01", null);
        } else {
            // El trabajador no fue encontrado en la base de datos
            return new IngresoResponse("99", "Trabajador not found for ID: " + idTraId);
        }
    }



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
                    .idtra(ingreso.getIdtra())
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
                    .idtra(ingresosSave.getIdtra())
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
                        .idtra(ingresosUpdate.getIdtra())
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
                                .idtra(ingresos.getIdtra())
                                .build())
                        .build()
                ,HttpStatus.OK);
    }
}
