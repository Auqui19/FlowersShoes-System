package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Cliente;
import com.flowersshoes.sistemadealmacen.model.Ingresos;
import com.flowersshoes.sistemadealmacen.model.dto.IngresosDto;
import com.flowersshoes.sistemadealmacen.repository.IngresosRepository;
import com.flowersshoes.sistemadealmacen.service.IIngresos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngresosImpl implements IIngresos {

    @Autowired
    private IngresosRepository ingresosRepository;

    @Transactional
    @Override
    public Ingresos save(IngresosDto ingresosDto) {
        Ingresos ingresos = Ingresos.builder()
                .idingre(ingresosDto.getIdingre())
                .descripcion(ingresosDto.getDescripcion())
                .estado(ingresosDto.getEstado())
                .fecha(ingresosDto.getFecha())
                .trabajador(ingresosDto.getTrabajador())
                .build();
        return ingresosRepository.save(ingresos);
    }

    @Transactional(readOnly = true)
    @Override
    public Ingresos findById(Integer id) {
        return ingresosRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Ingresos ingresos) {
        ingresosRepository.delete(ingresos);
    }

    @Override
    public boolean existsById(Integer id) {
        return ingresosRepository.existsById(id);
    }
}
