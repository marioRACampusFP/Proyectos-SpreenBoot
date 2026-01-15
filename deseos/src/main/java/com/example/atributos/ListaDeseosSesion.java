package com.example.atributos;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


import java.util.ArrayList;


@Service
@SessionScope
public class ListaDeseosSesion {
    private ArrayList<String> deseos;


    public ListaDeseosSesion() {
        this.deseos = new ArrayList<String>();
    }
    public ArrayList<String> getDeseos() {
        return deseos;
    }
}
