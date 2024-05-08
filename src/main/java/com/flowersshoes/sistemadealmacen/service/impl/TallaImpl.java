package com.flowersshoes.sistemadealmacen.service.impl;

import com.flowersshoes.sistemadealmacen.model.Color;
import com.flowersshoes.sistemadealmacen.model.Talla;
import com.flowersshoes.sistemadealmacen.repository.IngresosRepository;
import com.flowersshoes.sistemadealmacen.repository.TallaRepository;
import com.flowersshoes.sistemadealmacen.service.ITalla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallaImpl implements ITalla {

    @Autowired
    private TallaRepository tallaRepository;


    @Override
    public Talla save(Talla talla) {
        talla.setEstado("Activo");
        return tallaRepository.save(talla);
    }

    @Override
    public List<Talla> findAll() {
        return tallaRepository.findAll();
    }

    @Override
    public Talla findById(Integer id) {
        return tallaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(Integer id) {
        return tallaRepository.existsById(id);
    }

    @Override
    public Talla status(Integer id) {
        Talla talla = tallaRepository.findById(id).orElse(null);
        if(talla.getEstado().equals("Activo")){
            talla.setEstado("Inactivo");
            return tallaRepository.save(talla);
        }else{
            talla.setEstado("Activo");
            return tallaRepository.save(talla);
        }
    }


}
