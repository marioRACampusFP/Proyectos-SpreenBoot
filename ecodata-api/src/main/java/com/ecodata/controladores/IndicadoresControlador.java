// src/main/java/com/ecodata/controladores/IndicadoresControlador.java

package com.ecodata.controladores;

import com.ecodata.jpa.Indicador;
import com.ecodata.servicios.IServicioIndicadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/indicadores")
@CrossOrigin(origins = "*")
public class IndicadoresControlador {

    private final IServicioIndicadores servicioIndicadores;

    @Autowired
    public IndicadoresControlador(IServicioIndicadores servicioIndicadores) {
        this.servicioIndicadores = servicioIndicadores;
    }

    // GET todos
    @GetMapping("/todos")
    public List<Indicador> todos() {
        return servicioIndicadores.listarIndicadores();
    }

    // GET por ID (con parámetro en URL)
    @GetMapping("/{id}")
    public Indicador porId(@PathVariable("id") Integer id) {
        return servicioIndicadores.obtenerIndicador(id);
    }

    // GET filtrado por tipo
    @GetMapping("/tipo/{tipo}")
    public List<Indicador> porTipo(@PathVariable("tipo") String tipo) {
        return servicioIndicadores.listarPorTipo(tipo);
    }

    // GET resumen (con query nativa)
    @GetMapping("/resumen")
    public List<Object[]> resumen() {
        return servicioIndicadores.obtenerResumenPorTipo();
    }

    // POST nuevo
    @PostMapping("/nuevo")
    public Indicador nuevo(@RequestBody Indicador i) {
        servicioIndicadores.guardarIndicador(i);
        return i;
    }

    // PUT actualizar (usa save para UPDATE si ID existe)
    @PutMapping("/actualizar/{id}")
    public Indicador actualizar(@PathVariable("id") Integer id, @RequestBody Indicador nuevo) {
        Indicador existente = servicioIndicadores.obtenerIndicador(id);
        if (existente != null) {
            existente.setTipo(nuevo.getTipo());
            existente.setCategoria(nuevo.getCategoria());
            existente.setNombre(nuevo.getNombre());
            existente.setDescripcion(nuevo.getDescripcion());
            existente.setValor(nuevo.getValor());
            existente.setUnidad(nuevo.getUnidad());
            existente.setFecha(nuevo.getFecha());
            existente.setAmbito(nuevo.getAmbito());
            servicioIndicadores.guardarIndicador(existente);
            return existente;
        }
        return null;
    }

    // DELETE eliminar
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        servicioIndicadores.eliminarIndicador(id);
    }
}