// src/main/java/com/ecodata/servicios/IServicioIndicadores.java

package com.ecodata.servicios;

import com.ecodata.jpa.Indicador;
import java.util.List;

public interface IServicioIndicadores {
    List<Indicador> listarIndicadores();
    Indicador obtenerIndicador(Integer id);
    void guardarIndicador(Indicador indicador);
    void eliminarIndicador(Integer id);
    List<Indicador> listarPorTipo(String tipo);
    List<Object[]> obtenerResumenPorTipo();
}