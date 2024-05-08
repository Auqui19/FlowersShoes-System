package com.flowersshoes.sistemadealmacen.repository;

import com.flowersshoes.sistemadealmacen.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {

}
