package com.mitienda.service;

import com.mitienda.model.Producto;
import com.mitienda.repository.ProductoDao;
import com.mitienda.repository.ProductoDaoImpl;

import java.util.List;

public class TiendaService {
    private final ProductoDao productoDao;

    public TiendaService() {
        this.productoDao = new ProductoDaoImpl();
    }

    public void registrarProducto(Producto p) {
        if (p.getPrecio() == null || p.getPrecio() <= 0) {
            System.out.println("El precio debe ser mayor a 0.");
            return;
        }
        productoDao.guardar(p);
    }

    public List<Producto> obtenerCatalogo() {
        return productoDao.listarTodos();
    }

    public boolean procesarVenta(int idProducto, int cantidad) {
        Producto p = productoDao.buscarPorId(idProducto);
        if (p == null) {
            System.out.println("Producto no encontrado.");
            return false;
        }

        if (p.getStock() < cantidad) {
            System.out.println("Stock insuficiente.");
            return false;
        }

        p.setStock(p.getStock() - cantidad);
        productoDao.actualizar(p);
        System.out.println("Venta procesada con éxito.");
        return true;
    }
}
