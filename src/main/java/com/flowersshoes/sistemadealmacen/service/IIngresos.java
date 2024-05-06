package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Ingresos;
import com.flowersshoes.sistemadealmacen.model.dto.IngresosDto;

public interface IIngresos {

    Ingresos save(IngresosDto ingresos);
    Ingresos findById(Integer id);
    void delete(Ingresos ingresos);
    boolean existsById(Integer id);
}
