package es.peliculas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Director")
@Getter @Setter @NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_director")
    private Integer idDirector;

    private String nombre;

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    private List<Pelicula> peliculas = new ArrayList<>();
}