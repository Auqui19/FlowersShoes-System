package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Color;
import com.flowersshoes.sistemadealmacen.model.Producto;
import com.flowersshoes.sistemadealmacen.model.Talla;
import com.flowersshoes.sistemadealmacen.model.dto.ProductosDto;
import com.flowersshoes.sistemadealmacen.repository.ColorRepository;
import com.flowersshoes.sistemadealmacen.repository.ProductoRepository;
import com.flowersshoes.sistemadealmacen.repository.TallaRepository;
import com.flowersshoes.sistemadealmacen.service.IColor;
import com.flowersshoes.sistemadealmacen.service.IProducto;
import com.flowersshoes.sistemadealmacen.service.ITalla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImpl implements IProducto {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private TallaRepository tallaRepository;

    @Override
    public Producto save(ProductosDto productoDto) {
        boolean productoexistente = false;
        Color color = colorRepository.findById(productoDto.getIdcolor()).orElse(null) ;
        Talla talla = tallaRepository.findById(productoDto.getIdtalla()).orElse(null);
       Producto producto = new Producto();
       producto.setCodbar(productoDto.getNompro()+productoDto.getIdtalla()+productoDto.getIdcolor());
       producto.setNompro(productoDto.getNompro());
       producto.setPrecio(productoDto.getPrecio());
       producto.setTalla(talla);
       producto.setColor(color);
       producto.setCategoria(productoDto.getCategoria());
       producto.setTemporada(productoDto.getTemporada());
       producto.setDescripcion(productoDto.getDescripcion());
       producto.setEstado("Activo");

       Iterable<Producto> productoList = productoRepository.findAll();
       for(Producto p: productoList){
           if(p.getCodbar().equals(producto.getCodbar())){
               productoexistente = true;
               break;
           }
       }

       if(!productoexistente){
           producto = productoRepository.save(producto);
           producto.setImagen(producto.getIdpro()+".jpg");
           producto = productoRepository.save(producto);
       }else{
           throw new RuntimeException("El producto ya existe.");
       }

       return producto;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Integer id) {
        return null;
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }
}
