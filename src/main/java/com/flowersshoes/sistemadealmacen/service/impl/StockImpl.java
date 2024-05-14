package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Stock;
import com.flowersshoes.sistemadealmacen.repository.ColorRepository;
import com.flowersshoes.sistemadealmacen.repository.StockRepository;
import com.flowersshoes.sistemadealmacen.service.IStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockImpl implements IStock {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock SaveStock(Stock S) {
        return stockRepository.save(S);
    }

    @Override
    public Stock BuscarStock(Integer id) {
        return null;
    }

    @Override
    public void DeleteStock(Stock S) {

    }

    @Override
    public Iterable<Stock> FindAllStock() {
        return stockRepository.findAll();
    }
}
