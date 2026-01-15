package com.example.forms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Controlador {


    @Autowired
    private Carrito carrito;


    @RequestMapping("/")
    public ModelAndView home(ModelMap model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("producto", new Producto());
        model.addAttribute("carrito", carrito.getProductos());
        mv.setViewName("index");
        return mv;
    }


    @RequestMapping("/nuevo")
    public String nuevo(Producto p) {
        System.out.println(p);
        carrito.getProductos().add(p);
        return "redirect:/";
    }
}
