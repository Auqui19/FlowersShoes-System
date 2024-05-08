package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Ingresos;
import com.flowersshoes.sistemadealmacen.model.dto.IngresosDto;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IIngresos {

    //Guardar un Ingreso
    Ingresos save(IngresosDto ingresos);

    //Buscar un ingreso por su ID
    Ingresos findById(Integer id);

    //Eliminar un ingreso
    void delete(Ingresos ingresos);

    //Listar todos los ingresos
    Iterable<Ingresos> findAll();

    //Busar si exite un ID de ingreso
    boolean existsById(Integer id);
}
