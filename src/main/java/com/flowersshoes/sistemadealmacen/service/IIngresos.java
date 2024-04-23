package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Ingresos;

public interface IIngresos {

    Ingresos save(Ingresos ingresos);
    Ingresos findById(Integer id);
    void delete(Ingresos ingresos);
}
