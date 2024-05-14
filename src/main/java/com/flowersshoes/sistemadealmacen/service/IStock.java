package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Stock;
import com.flowersshoes.sistemadealmacen.model.Talla;

import java.util.List;

public interface IStock {

    Iterable<Stock> FindAllStock();
    /*
    Stock findById(Integer id);

     */
}
