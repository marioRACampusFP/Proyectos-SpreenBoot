// src/main/java/com/ecodata/servicios/ServicioIndicadores.java

package com.ecodata.servicios;

import com.ecodata.jpa.Indicador;
import com.ecodata.repositorios.IndicadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioIndicadores implements IServicioIndicadores {

    private final IndicadorRepositorio repositorio;

    @Autowired
    public ServicioIndicadores(IndicadorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Indicador> listarIndicadores() {
        return repositorio.findAll();
    }

    @Override
    public Indicador obtenerIndicador(Integer id) {
        Optional<Indicador> opt = repositorio.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void guardarIndicador(Indicador indicador) {
        repositorio.save(indicador);
    }

    @Override
    public void eliminarIndicador(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Indicador> listarPorTipo(String tipo) {
        return repositorio.findByTipo(tipo);
    }

    @Override
    public List<Object[]> obtenerResumenPorTipo() {
        return repositorio.obtenerResumenPorTipo();
    }
}