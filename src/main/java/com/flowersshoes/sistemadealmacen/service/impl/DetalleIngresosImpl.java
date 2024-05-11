package com.flowersshoes.sistemadealmacen.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalleIngresosImpl {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void grabarDetalleIngreso(int idingre, int idpro, int cantidad) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_GRABAR_DETALLE_INGRESOS")
                .registerStoredProcedureParameter("idingre", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("idpro", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("cantidad", Integer.class, ParameterMode.IN)
                .setParameter("idingre", idingre)
                .setParameter("idpro", idpro)
                .setParameter("cantidad", cantidad);
        query.execute();
    }
}
