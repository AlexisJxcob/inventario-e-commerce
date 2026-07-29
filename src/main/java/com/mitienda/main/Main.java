package com.mitienda.main;

import com.mitienda.repository.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Intentando conectar a tu base de datos de Supabase...");

        try (Connection con = DatabaseConnection.getConnection()) {
            if (con != null && !con.isClosed()) {
                System.out.println("=========================================");
                System.out.println(" ¡CONEXIÓN EXITOSA CON SUPABASE! ");
                System.out.println("=========================================");
            }
        } catch (SQLException e) {
            System.err.println("Error crítico de conexión:");
            e.printStackTrace();
        }
    }
}
