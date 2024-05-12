package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Stock;
import com.flowersshoes.sistemadealmacen.repository.StockRepository;
import com.flowersshoes.sistemadealmacen.service.IStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StockImpl implements IStock {

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> findAll() {
        return (List<Stock>) stockRepository.findAll();
    }

    @Override
    public Stock findById(Integer id) {
        return stockRepository.findById(id).orElse(null);
    }
}
