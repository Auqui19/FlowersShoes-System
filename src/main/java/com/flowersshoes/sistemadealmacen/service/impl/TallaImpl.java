package com.flowersshoes.sistemadealmacen.service.impl;

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
        boolean tallaexistente = false;

        Iterable<Talla> tallasList = tallaRepository.findAll();
        for ( Talla t: tallasList){
            if (t.getTalla().equals(talla.getTalla()) ){
                tallaexistente = true;
                break;
            }
        }

        if (!tallaexistente){
            talla.setEstado("Activo");
            tallaRepository.save(talla);
        }else {
            throw new RuntimeException("La talla ya existe.");
        }

        return talla;
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


}
