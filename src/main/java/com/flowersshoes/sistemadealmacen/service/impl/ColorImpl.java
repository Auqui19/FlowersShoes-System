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
        color.setEstado("Activo");

        return colorRepository.save(color);
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

    @Override
    public Color status(Integer id) {
        Color color = colorRepository.findById(id).orElse(null);
        if (color.getEstado().equals("Activo")) {
            color.setEstado("Inactivo");
            return colorRepository.save(color);
        } else {
            color.setEstado("Activo");
            return colorRepository.save(color);
        }
    }
}
