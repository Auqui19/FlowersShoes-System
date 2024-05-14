package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.DetalleIngresos;
import com.flowersshoes.sistemadealmacen.model.Ingresos;
import com.flowersshoes.sistemadealmacen.model.Producto;
import com.flowersshoes.sistemadealmacen.model.Trabajador;
import com.flowersshoes.sistemadealmacen.model.dto.DetalleIngresoDto;
import com.flowersshoes.sistemadealmacen.model.dto.IngresosDto;
import com.flowersshoes.sistemadealmacen.repository.IngresosRepository;
import com.flowersshoes.sistemadealmacen.repository.ProductoRepository;
import com.flowersshoes.sistemadealmacen.repository.TrabajadorRepository;
import com.flowersshoes.sistemadealmacen.service.IIngresos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IngresosImpl implements IIngresos {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IngresosRepository ingresosRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;
    @Autowired
    private ProductoRepository productoRepository;


    // Procedures

    @Transactional
    public int grabarIngreso(int idtra, String descripcion , List<DetalleIngresoDto> detalles) {
        Trabajador trabajador = trabajadorRepository.findById(idtra).orElse(null);

        if (trabajador != null) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_GRABAR_INGRESOS")
                    .registerStoredProcedureParameter("idtra", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("descrip", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.OUT)
                    .setParameter("idtra", idtra)
                    .setParameter("descrip", descripcion);
            query.execute();

            int idingre = (int) query.getOutputParameterValue("id");
            for (DetalleIngresoDto detalle : detalles) {
                grabarDetalleIngreso(idingre, detalle.getIdpro(), detalle.getCantidad());
            }
            return idingre;
        }else {
            return 0;
        }
    }

    @Transactional
    public void grabarDetalleIngreso(int idingre, int idpro, int cantidad) {
        Ingresos ingreso = ingresosRepository.findById(idingre).orElse(null);
        Producto producto = productoRepository.findById(idpro).orElse(null);
        if (producto != null && ingreso != null) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_GRABAR_DETALLE_INGRESOS")
                    .registerStoredProcedureParameter("idi", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("idprod", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("cant", Integer.class, ParameterMode.IN)
                    .setParameter("idi", idingre)
                    .setParameter("idprod", idpro)
                    .setParameter("cant", cantidad);
            query.execute();
        }
    }




    @Transactional
    public List<IngresosDto> listarIngresos() {
        StoredProcedureQuery queryI = entityManager.createStoredProcedureQuery("PA_LISTAR_INGRESOS");

        List<Object[]> resultsI = queryI.getResultList();
        List<IngresosDto> listadoIDto = new ArrayList<>();

        for (Object[] result : resultsI){
            IngresosDto ingreDto = new IngresosDto();
            ingreDto.setIdingre((Integer) result[0]);
            ingreDto.setFecha((Date) result[1]);
            ingreDto.setNomtra((String) result[2]);
            ingreDto.setDescripcion((String) result[3]);
            ingreDto.setEstado((String) result[4]);
            StoredProcedureQuery queryDI = entityManager.createStoredProcedureQuery("PA_LISTAR_DETALLE_INGRESOS")
                    .registerStoredProcedureParameter("iding", Integer.class, ParameterMode.IN)
                    .setParameter("iding", ingreDto.getIdingre());
            List<Object[]> resultsDI = queryDI.getResultList();
            List<DetalleIngresoDto> listadoDiDto = new ArrayList<>();
            for (Object[] resultDI : resultsDI){
                DetalleIngresoDto diDto = new DetalleIngresoDto();

                diDto.setIdingre((Integer) resultDI[0]);
                diDto.setIdpro((Integer) resultDI[1]);
                diDto.setImagen((String) resultDI[2]);
                diDto.setNompro((String) resultDI[3]);
                diDto.setColor((String) resultDI[4]);
                diDto.setTalla((String) resultDI[5]);
                diDto.setCantidad((Integer) resultDI[6]);
                listadoDiDto.add(diDto);
            }
            ingreDto.setDetalles(listadoDiDto);

            listadoIDto.add(ingreDto);
        }
        return listadoIDto ;
    }

}
