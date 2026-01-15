

package com.ecodata.repositorios;

import com.ecodata.jpa.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IndicadorRepositorio extends JpaRepository<Indicador, Integer> {

    List<Indicador> findByTipo(String tipo);

    // Query nativa para resumen (ejemplo de conteo por tipo, como SUM en los PDFs)
    @Query(value = "SELECT tipo, COUNT(*) FROM Indicador GROUP BY tipo", nativeQuery = true)
    List<Object[]> obtenerResumenPorTipo();
}