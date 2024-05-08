package com.flowersshoes.sistemadealmacen.service;

import com.flowersshoes.sistemadealmacen.model.Cliente;
import java.util.List;

public interface ICliente {
    Cliente SaveCliente(Cliente C);
    Cliente BuscarCliente(Integer id);
    void DeleteCliente (Cliente C);
    Iterable<Cliente> FindAllClientes();
    boolean ExystClienteById(Integer id);
}
