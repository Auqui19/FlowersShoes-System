package com.flowersshoes.sistemadealmacen.repository;

import com.flowersshoes.sistemadealmacen.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ColorRepository extends JpaRepository<Color, Integer> {

}
