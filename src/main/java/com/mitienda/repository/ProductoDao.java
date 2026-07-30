package com.mitienda.repository;

import com.mitienda.model.Producto;

import java.util.List;

public interface ProductoDao {

    void guardar(Producto producto);

    List<Producto> listarTodos();

    Producto buscarPorId(int id);

    void actualizar(Producto producto);

    void eliminar(int id);
}