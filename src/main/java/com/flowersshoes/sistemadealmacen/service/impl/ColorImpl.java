package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Color;
import com.flowersshoes.sistemadealmacen.repository.ColorRepository;
import com.flowersshoes.sistemadealmacen.service.IColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorImpl implements IColor {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Color save(Color color) {
       boolean colorexistente = false;

       Iterable<Color> colorList = colorRepository.findAll();
       for (Color c: colorList){
           if (c.getColor().equals(color.getColor())){
               colorexistente = true;
               break;
           }
       }

       if (!colorexistente){
           color.setEstado("Activo");
           colorRepository.save(color);
       }else {
           throw new RuntimeException(("El color ya existe."));
       }

        return color;
    }

    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Color findById(Integer id) {
        return colorRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Integer id) {
        return colorRepository.existsById(id);
    }
}
