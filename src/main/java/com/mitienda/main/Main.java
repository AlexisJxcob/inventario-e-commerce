package com.mitienda.main;

import com.mitienda.service.TiendaService;

public class Main {
    public static void main(String[] args) {
        TiendaService service = new TiendaService();

        System.out.println("--- PROBANDO CONEXIÓN Y DATOS EN SUPABASE ---");

        // Listar catálogo desde la base de datos
        service.obtenerCatalogo().forEach(System.out::println);
    }
}