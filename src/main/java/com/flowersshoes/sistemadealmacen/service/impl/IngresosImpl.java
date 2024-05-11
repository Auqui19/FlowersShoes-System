package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Ingresos;
import com.flowersshoes.sistemadealmacen.model.dto.IngresosDto;
import com.flowersshoes.sistemadealmacen.repository.IngresosRepository;
import com.flowersshoes.sistemadealmacen.service.IIngresos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngresosImpl implements IIngresos {

    @Autowired
    private EntityManager entityManager;

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
    public Iterable<Ingresos> findAll() {
        return ingresosRepository.findAll();
    }


    @Override
    public boolean existsById(Integer id) {
        return ingresosRepository.existsById(id);
    }

    // Procedures

    @Transactional
    public int grabarIngreso(int idtra, String descripcion) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_GRABAR_INGRESOS")
                .registerStoredProcedureParameter("idtra", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("descripcion", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.OUT)
                .setParameter("idtra", idtra)
                .setParameter("descripcion", descripcion);
        query.execute();
        return (int) query.getOutputParameterValue("id");
    }
}
