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

}