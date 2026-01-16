package com.example.atributos;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import java.util.ArrayList;


@Service
@ApplicationScope
public class ListaDeseosAplicacion {
    private ArrayList<String> deseos;


    public ListaDeseosAplicacion() {
        this.deseos = new ArrayList<String>();
    }
    public ArrayList<String> getDeseos() {
        return deseos;
    }
}
