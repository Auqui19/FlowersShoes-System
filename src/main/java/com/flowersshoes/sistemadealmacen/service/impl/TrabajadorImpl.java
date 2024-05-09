package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Rol;
import com.flowersshoes.sistemadealmacen.model.Trabajador;
import com.flowersshoes.sistemadealmacen.model.dto.TrabajadorDto;
import com.flowersshoes.sistemadealmacen.repository.RolRepository;
import com.flowersshoes.sistemadealmacen.repository.TrabajadorRepository;
import com.flowersshoes.sistemadealmacen.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorImpl implements ITrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Trabajador save(TrabajadorDto trabajadorDto) {
        Rol rol = rolRepository.findById(trabajadorDto.getIdrol()).orElse(null);
        String passwordEncriptado = passwordEncoder.encode(trabajadorDto.getPassword());

        Trabajador trabajador = Trabajador.builder()
                .idtra(trabajadorDto.getIdtra())
                .nombres(trabajadorDto.getNombres())
                .nrodocumento(trabajadorDto.getNrodocumento())
                .rol(rol)
                .estado("Activo")
                .tipodocumento(trabajadorDto.getTipodocumento())
                .direccion(trabajadorDto.getDireccion())
                .email(trabajadorDto.getEmail())
                .password(passwordEncriptado)
                .build();
        return trabajadorRepository.save(trabajador);
    }

    @Override
    public List<Trabajador> findAll() {
        return (List<Trabajador>) trabajadorRepository.findAll();
    }

    @Override
    public Trabajador findById(Integer id) {
        return trabajadorRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Integer id) {
        return trabajadorRepository.existsById(id);
    }

    @Override
    public Trabajador status(Integer id) {
        Trabajador trabajador = trabajadorRepository.findById(id).orElse(null);
        if (trabajador != null) {
            if (trabajador.getEstado().equals("Activo")) {
                trabajador.setEstado("Inactivo");
            } else {
                trabajador.setEstado("Activo");
            }
            return trabajadorRepository.save(trabajador);
        }
        return null;
    }
}
