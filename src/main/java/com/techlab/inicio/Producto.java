package com.techlab.inicio;

public class Producto {
    private static int SIGUIENTE_ID = 1;
    private final int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    public Producto(String nombre, String descripcion, double precio, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.id = SIGUIENTE_ID;
        SIGUIENTE_ID++;
    }

    public void mostrarInfo(){
        System.out.printf("""
                Id: %s
                Nombre: %s
                Descripcion: %s
                Precio: %s
                Stock: %s
                """, this.id, this.nombre, this.descripcion , this.precio, this.stock);

    }

    // GETTERS y SETTERS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}