package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.*;
import com.flowersshoes.sistemadealmacen.model.dto.DetalleIngresoDto;
import com.flowersshoes.sistemadealmacen.model.dto.DetalleVentaDto;
import com.flowersshoes.sistemadealmacen.model.dto.IngresosDto;
import com.flowersshoes.sistemadealmacen.model.dto.VentaDto;
import com.flowersshoes.sistemadealmacen.repository.*;
import com.flowersshoes.sistemadealmacen.service.IVenta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VentaImpl implements IVenta {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @Transactional
    public int grabarVenta(int idtra, int idcli, List<DetalleVentaDto> detalles) {
        Cliente cliente = clienteRepository.findById(idcli).orElse(null);
        Trabajador trabajador = trabajadorRepository.findById(idtra).orElse(null);
        if (cliente != null && trabajador != null) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_GRABAR_VENTA")
                    .registerStoredProcedureParameter("idtra", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("idcli", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.OUT)
                    .setParameter("idtra", idtra)
                    .setParameter("idcli", idcli);

            query.execute();
            int idVenta = (int) query.getOutputParameterValue("id");
            for (DetalleVentaDto detalle : detalles) {
                grabarDetalleVenta(idVenta, detalle.getIdpro(), detalle.getCantidad());
            }
            return idVenta;
        } else {
            return 0;
        }
    }


    // Procedures
    @Transactional
    public String grabarDetalleVenta(int idventa, int idpro, int cantidad) {
        Ventas venta = ventaRepository.findById(idventa).orElse(null);
        Producto producto = productoRepository.findById(idpro).orElse(null);

        if (producto != null && venta != null) {
            double precioUni = producto.getPrecio();
            double subtotal = cantidad * precioUni;

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_GRABAR_DETALLE_VENTA")
                    .registerStoredProcedureParameter("idv", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("idprod", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("cant", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("precioUni", Double.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("subtotal", Double.class, ParameterMode.IN)
                    .setParameter("idv", idventa)
                    .setParameter("idprod", idpro)
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
    public List<VentaDto> listarVentas() {
        StoredProcedureQuery queryV = entityManager.createStoredProcedureQuery("PA_LISTAR_VENTAS");

        List<Object[]> resultsV = queryV.getResultList();
        List<VentaDto> listadoVDto = new ArrayList<>();

        for (Object[] result : resultsV){
            VentaDto ventaDto = new VentaDto();

            ventaDto.setIdventa((Integer) result[0]);
            ventaDto.setFecha((Date) result[1]);
            ventaDto.setNomtra((String) result[2]);
            ventaDto.setNomcli((String) result[3]);
            ventaDto.setTotal((double) result[4]);
            ventaDto.setEstadocomprobante((String) result[5]);
            ventaDto.setEstado((String) result[6]);
            StoredProcedureQuery queryDV = entityManager.createStoredProcedureQuery("PA_LISTAR_DETALLE_VENTAS")
                    .registerStoredProcedureParameter("idven", Integer.class, ParameterMode.IN)
                    .setParameter("idven", ventaDto.getIdventa());
            List<Object[]> resultsDV = queryDV.getResultList();
            List<DetalleVentaDto> listadoDvDto = new ArrayList<>();
            for (Object[] resultDV : resultsDV){
                DetalleVentaDto dvDto = new DetalleVentaDto();

                dvDto.setIdventa((Integer) resultDV[0]);
                dvDto.setIdpro((Integer) resultDV[1]);
                dvDto.setImagen((String) resultDV[2]);
                dvDto.setNompro((String) resultDV[3]);
                dvDto.setColor((String) resultDV[4]);
                dvDto.setTalla((String) resultDV[5]);
                dvDto.setCantidad((Integer) resultDV[6]);
                dvDto.setPreciouni((double) resultDV[7]);
                dvDto.setSubtotal((double) resultDV[8]);
                listadoDvDto.add(dvDto);
            }
            ventaDto.setDetalles(listadoDvDto);

            listadoVDto.add(ventaDto);
        }
        return listadoVDto ;
    }








































/**

    @Transactional
    public void eliminarVenta(int idventa) {
        Ventas venta = ventaRepository.findById(idventa).orElse(null);
        if (venta != null) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_ELIMINAR_VENTA")
                    .registerStoredProcedureParameter("idv", Integer.class, ParameterMode.IN)
                    .setParameter("idventa", idventa);
            query.execute();
        }
    }

    @Transactional
    public void restaurarVenta(int idventa) {
        Ventas venta = ventaRepository.findById(idventa).orElse(null);
        if (venta != null) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_RESTAURAR_VENTA")
                    .registerStoredProcedureParameter("idv", Integer.class, ParameterMode.IN)
                    .setParameter("idve", idventa);
            query.execute();
        }
    }

    @Transactional
    public void editarVenta(int idventa, String estadoComprobante) {
        Ventas venta = ventaRepository.findById(idventa).orElse(null);
        if (venta != null) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_EDITAR_VENTA")
                    .registerStoredProcedureParameter("idventa", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("estadoComprobante", String.class, ParameterMode.IN)
                    .setParameter("idventa", idventa)
                    .setParameter("estadoComprobante", estadoComprobante);
            query.execute();
        }
    }

    public List<Object[]> listarVentas() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PA_LISTAR_VENTAS");
        return query.getResultList();
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


    @Transactional
    @Override
    public Ventas save(VentaDto ventaDto) {
        Trabajador trabajador = trabajadorRepository.findById(ventaDto.getIdtra()).orElse(null);
        Cliente cliente = clienteRepository.findById(ventaDto.getIdcli()).orElse(null);
        Ventas venta = new Ventas();
        venta.setTrabajador(trabajador);
        venta.setCliente(cliente);
        venta.setIdventa(ventaDto.getIdventa());
        venta.setFecha(ventaDto.getFecha());
        venta.setTotal(ventaDto.getTotal());
        venta.setEstado(ventaDto.getEstado());
        venta.setEstadocomprobante(ventaDto.getEstadocomprobante());

        venta = ventaRepository.save(venta);

        return ventaRepository.save(venta);

    }

    @Transactional
    @Override
    public Ventas findById(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Ventas venta) {
        ventaRepository.delete(venta);
    }

    @Override
    public Iterable<Ventas> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    public boolean existsById(Integer id) {
        return ventaRepository.existsById(id);
    }**/
}
