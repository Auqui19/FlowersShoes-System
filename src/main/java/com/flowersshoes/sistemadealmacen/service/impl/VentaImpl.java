package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Cliente;
import com.flowersshoes.sistemadealmacen.model.Trabajador;
import com.flowersshoes.sistemadealmacen.model.Ventas;
import com.flowersshoes.sistemadealmacen.model.dto.VentaDto;
import com.flowersshoes.sistemadealmacen.repository.ClienteRepository;
import com.flowersshoes.sistemadealmacen.repository.TrabajadorRepository;
import com.flowersshoes.sistemadealmacen.repository.VentaRepository;
import com.flowersshoes.sistemadealmacen.service.IVenta;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaImpl implements IVenta {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    @Override
    public Ventas save(VentaDto ventaDto){
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
    public Ventas findById(Integer id) {return ventaRepository.findById(id).orElse(null); }

    @Transactional
    @Override
    public  void delete(Ventas venta){ventaRepository.delete(venta); }

    @Override
    public Iterable<Ventas> findAll(){return ventaRepository.findAll(); }

    @Override
    public boolean existsById(Integer id) {return ventaRepository.existsById(id); }

}
