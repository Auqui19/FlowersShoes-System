package com.flowersshoes.sistemadealmacen.controller;
import com.flowersshoes.sistemadealmacen.model.dto.ProductosDto;
import com.flowersshoes.sistemadealmacen.service.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto/")
public class ProductoController {
    @Autowired
    private IProducto productoService;

    @GetMapping("listado")
    public ResponseEntity<?> listado(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }
    @GetMapping("encontrar/{id}")
    public ResponseEntity<?> findbyid(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody ProductosDto productosDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoService.save(productosDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error. Por favor inténtelo más tarde.\"}");
        }
    }

    @DeleteMapping("status/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoService.status(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error. Por favor inténtelo más tarde.\"}");
        }
    }



}
