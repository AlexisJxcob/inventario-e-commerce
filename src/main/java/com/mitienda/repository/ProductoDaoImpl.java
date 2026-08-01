package com.mitienda.repository;

import com.mitienda.model.Categoria;
import com.mitienda.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImpl implements ProductoDao {

    @Override
    public void guardar(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio, stock, categoria) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getStock());
            // FIX: getCategoria() ahora devuelve Categoria, no String -> convertimos con .name()
            stmt.setString(4, producto.getCategoria().name());

            stmt.executeUpdate();
            System.out.println("✓ Producto guardado correctamente en Supabase.");

        } catch (SQLException e) {
            System.err.println("Error al guardar producto: " + e.getMessage());
        }
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, stock, categoria FROM productos";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        Categoria.valueOf(rs.getString("categoria"))
                );
                productos.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }

        return productos;
    }

    @Override
    public Producto buscarPorId(int id) {
        String sql = "SELECT id, nombre, precio, stock, categoria FROM productos WHERE id = ?";
        Producto producto = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // FIX: antes se creaba "producto" vacio y se llenaba una variable "p" aparte
                    // que nunca se asignaba de vuelta a "producto" -> el metodo siempre devolvia null.
                    producto = new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getInt("stock"),
                            Categoria.valueOf(rs.getString("categoria"))
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar producto por ID: " + e.getMessage());
        }

        return producto;
    }

    @Override
    public void actualizar(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ?, categoria = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getStock());
            stmt.setString(4, producto.getCategoria().name());
            stmt.setInt(5, producto.getId());

            stmt.executeUpdate();
            System.out.println("✓ Producto actualizado con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✓ Producto eliminado con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
        }
    }
}
