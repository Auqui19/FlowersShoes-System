package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Color;

import java.util.List;

public interface IColor {
    Color save(Color color);
    List<Color> findAll();
}
