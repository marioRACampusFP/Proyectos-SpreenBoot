package com.example.atributos;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Controlador {
    @Autowired
    private ListaDeseosSesion listaDeseos;
    @Autowired
    private ListaDeseosAplicacion listaDeseosGlobal;


    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaDeseos", listaDeseos.getDeseos());
        mv.addObject("listaDeseosGlobal", listaDeseosGlobal.getDeseos());
        mv.setViewName("index");
        return mv;
    }


    @RequestMapping("/nuevo")
    public String nuevo(HttpServletRequest request) {
        String deseo = request.getParameter("deseo");
        listaDeseos.getDeseos().add(deseo);
        // Añadimos el deseo al atributo de sesión.
        listaDeseosGlobal.getDeseos().add(deseo);
        // Añadimos el deseo al atributo de aplicación.
        return "redirect:/";
        // Redirigimos a la petición raiz que actualizará la lista de deseos.
    }
}
