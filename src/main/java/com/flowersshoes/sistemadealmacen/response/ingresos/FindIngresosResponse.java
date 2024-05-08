package com.flowersshoes.sistemadealmacen.response.ingresos;

import com.flowersshoes.sistemadealmacen.model.Ingresos;

public record FindIngresosResponse(String code, String error, Iterable<Ingresos> ingresos) {
}
