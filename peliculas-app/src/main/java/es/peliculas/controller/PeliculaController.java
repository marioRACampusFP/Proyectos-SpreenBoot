package es.peliculas.controller;

import es.peliculas.repository.DirectorRepository;
import es.peliculas.repository.GeneroRepository;
import es.peliculas.repository.PeliculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peliculas")
@RequiredArgsConstructor
public class PeliculaController {

    private final DirectorRepository directorRepo;
    private final GeneroRepository generoRepo;
    private final PeliculaRepository peliculaRepo;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/director")
    public String porDirector(Model model) {
        model.addAttribute("directores", directorRepo.findAll());
        return "por-director";
    }

    @GetMapping("/genero")
    public String porGenero(Model model) {
        model.addAttribute("generos", generoRepo.findAll());
        return "por-genero";
    }

    @GetMapping("/peliculas")
    public String todasLasPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaRepo.findAll());
        return "lista-peliculas";
    }
}