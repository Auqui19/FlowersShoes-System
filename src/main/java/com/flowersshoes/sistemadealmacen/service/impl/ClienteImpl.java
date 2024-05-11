package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Cliente;
import com.flowersshoes.sistemadealmacen.repository.ClienteRepository;
import com.flowersshoes.sistemadealmacen.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteImpl implements ICliente {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        cliente.setEstado("Activo");
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente status(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            if (cliente.getEstado().equals("Activo")) {
                cliente.setEstado("Inactivo");
            } else {
                cliente.setEstado("Activo");
            }
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
