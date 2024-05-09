package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Color;
import com.flowersshoes.sistemadealmacen.model.Producto;
import com.flowersshoes.sistemadealmacen.model.Talla;
import com.flowersshoes.sistemadealmacen.model.dto.ProductosDto;
import com.flowersshoes.sistemadealmacen.repository.ColorRepository;
import com.flowersshoes.sistemadealmacen.repository.ProductoRepository;
import com.flowersshoes.sistemadealmacen.repository.TallaRepository;
import com.flowersshoes.sistemadealmacen.service.IProducto;
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
        Color color = colorRepository.findById(productoDto.getIdcolor()).orElse(null);
        Talla talla = tallaRepository.findById(productoDto.getIdtalla()).orElse(null);
        Producto producto = new Producto();
        producto.setIdpro(productoDto.getIdpro());
        producto.setCodbar(productoDto.getNompro() + productoDto.getIdtalla() + productoDto.getIdcolor());
        producto.setNompro(productoDto.getNompro());
        producto.setPrecio(productoDto.getPrecio());
        producto.setTalla(talla);
        producto.setColor(color);
        producto.setCategoria(productoDto.getCategoria());
        producto.setTemporada(productoDto.getTemporada());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setEstado("Activo");

        producto = productoRepository.save(producto);
        producto.setImagen(producto.getIdpro() + ".jpg");
        return productoRepository.save(producto);

    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Integer id) {
        return productoRepository.existsById(id);
    }

    @Override
    public Producto status(Integer id) {

        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto.getEstado().equals("Activo")) {
            producto.setEstado("Inactivo");
            return productoRepository.save(producto);
        } else {
            producto.setEstado("Activo");
            return productoRepository.save(producto);
        }

    }


}
