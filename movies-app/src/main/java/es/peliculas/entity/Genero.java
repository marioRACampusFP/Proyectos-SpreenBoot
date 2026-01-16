package es.peliculas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Genero")
@Getter @Setter @NoArgsConstructor
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Integer idGenero;

    private String nombre;

    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
    private List<Pelicula> peliculas = new ArrayList<>();
}