package com.example.forms;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


import java.util.ArrayList;


@Service
@SessionScope
public class Carrito {
    private ArrayList<Producto> productos;


    public Carrito() {
        this.productos = new ArrayList<Producto>();
    }


    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
