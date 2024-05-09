package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Stock;

public interface IStock {
    Stock SaveStock(Stock S);

    Stock BuscarStock(Integer id);

    void DeleteStock(Stock S);

    Iterable<Stock> FindAllStock();
}
