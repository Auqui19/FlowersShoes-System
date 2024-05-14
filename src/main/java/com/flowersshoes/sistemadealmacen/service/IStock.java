package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Stock;

public interface IStock {

    Iterable<Stock> FindAllStock();

    Stock findById(Integer id);


}
