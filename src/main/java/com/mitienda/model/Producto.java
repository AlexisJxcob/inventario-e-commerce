package com.mitienda.model;

public class Producto {

    private Integer id;
    private String nombre;
    private Double precio;
    private int stock;
    private Categoria categoria;

    public Producto() {
    }

    // constructor completo
    public Producto(Integer id, String nombre, Double precio, int stock, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // constructor en caso de que sea libro nuevo s
    public Producto(String nombre, Double precio, int stock, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // override
    @Override
    public String toString() {
        return String.format("[%d] %s | Categoria: %s | $%.2f | Stock: %d",
                id, nombre, categoria != null ? categoria.name() : "N/A", precio, stock);
    }
}
