package com.flowersshoes.sistemadealmacen.controller;

import com.flowersshoes.sistemadealmacen.model.Trabajador;
import com.flowersshoes.sistemadealmacen.model.dto.TrabajadorDto;
import com.flowersshoes.sistemadealmacen.repository.TrabajadorRepository;
import com.flowersshoes.sistemadealmacen.response.LoginResponse;
import com.flowersshoes.sistemadealmacen.security.JWTAuthenticationConfig;
import com.flowersshoes.sistemadealmacen.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trabajador/")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TrabajadorController {

    @Autowired
    private ITrabajadorService iTrabajadorService;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    JWTAuthenticationConfig jwtAuthenticationConfig;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody Trabajador trabajador){
        Trabajador tra = trabajadorRepository.findByEmail(trabajador.getEmail());
        if(tra == null){
            return new LoginResponse("99", "User not found", null);
        }
        if(!new BCryptPasswordEncoder().matches(trabajador.getPassword(), tra.getPassword())){
            return new LoginResponse("99", "Contraseña", null);
        }

        String token = jwtAuthenticationConfig.getJWTToken(tra.getEmail());
        return new LoginResponse("01", null, token);
    }

    @GetMapping("listado")
    public ResponseEntity<?> listado(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(iTrabajadorService.findAll());
        } catch (DataAccessException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("encontrar/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(iTrabajadorService.findById(id));
        } catch (DataAccessException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody TrabajadorDto trabajadorDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iTrabajadorService.save(trabajadorDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                    .body("{\"error\":\"Error. Por favor inténtelo más tarde.\"}");
        }
    }

    @DeleteMapping("status/{id}")
    public ResponseEntity<?> status(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(iTrabajadorService.status(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }
}
