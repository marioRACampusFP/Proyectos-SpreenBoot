package com.example.forms;


public class Producto {
    private String nombre;
    private int cantidad;
    private float precio;


    public Producto() {
        this.nombre = "Nombre del producto";
        this.cantidad = 0;
        this.precio = 0;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public float getPrecio() {
        return precio;
    }


    public void setPrecio(float precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
