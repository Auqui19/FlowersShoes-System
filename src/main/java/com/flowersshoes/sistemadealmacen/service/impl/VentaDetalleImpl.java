package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Producto;
import com.flowersshoes.sistemadealmacen.model.Ventas;
import com.flowersshoes.sistemadealmacen.repository.ProductoRepository;
import com.flowersshoes.sistemadealmacen.repository.VentaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VentaDetalleImpl {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public String grabarDetalleVenta(int idventa, int idpro, int cantidad) {
        Ventas venta = ventaRepository.findById(idventa).orElse(null);
        Producto producto = productoRepository.findById(idpro).orElse(null);

        if (producto != null) {
            double precioUni = producto.getPrecio();
            double subtotal = cantidad * precioUni;

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_GRABAR_DETALLE_VENTA")
                    .registerStoredProcedureParameter("idventa", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("idpro", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("cant", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("precioUni", Double.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("subtotal", Double.class, ParameterMode.IN)
                    .setParameter("idventa", idventa)
                    .setParameter("idpro", idpro)
                    .setParameter("cant", cantidad)
                    .setParameter("precioUni", precioUni)
                    .setParameter("subtotal", subtotal);

            query.execute();
            return "Detalle de venta grabado exitosamente";
        } else {
            throw new IllegalArgumentException("El producto no existe");
        }
    }

    @Transactional
    public void eliminarDetalleVenta(int idpro, int cantidad) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_ELIMINAR_DETALLE_VENTA")
                .registerStoredProcedureParameter("idpro", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("cantidad", Integer.class, ParameterMode.IN)
                .setParameter("idpro", idpro)
                .setParameter("cantidad", cantidad);
        query.execute();
    }

    @Transactional
    public void restaurarDetalleVenta(int idpro, int cantidad) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_RESTAURAR_DETALLE_VENTA")
                .registerStoredProcedureParameter("idpro", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("cantidad", Integer.class, ParameterMode.IN)
                .setParameter("idpro", idpro)
                .setParameter("cantidad", cantidad);
        query.execute();
    }

    public List<Object[]> listarDetalleVentas(int idventa) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_LISTAR_DETALLE_VENTAS");
        query.setParameter("idventa", idventa);
        return query.getResultList();
    }


}
