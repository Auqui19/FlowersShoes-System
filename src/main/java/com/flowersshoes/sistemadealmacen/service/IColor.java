package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Color;

import java.util.List;

public interface IColor {
    Color save(Color color);
    List<Color> findAll();
    Color findById(Integer id);
    boolean existsById(Integer id);
    Color status(Integer id);
}
