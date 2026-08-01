package com.mitienda.main;

import com.mitienda.model.Categoria;
import com.mitienda.model.Producto;
import com.mitienda.service.TiendaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TiendaService service = new TiendaService();

        System.out.println("--- PROBANDO CONEXIÓN Y DATOS EN SUPABASE ---");

        System.out.println("");

        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Ingresa la opcion que quiera hacer: ");
            System.out.println("1) Listar  2) Agregar  3) Vender  4) Salir");
            System.out.println("Opcion: ");
            Scanner option = new Scanner(System.in);
            int opcion = option.nextInt();
            switch (opcion) {
                case 1:
                    List<Producto> lista = service.obtenerCatalogo();
                    if (lista.isEmpty()) {
                        System.out.println("No se encontro el Catalogo");
                    } else {
                        lista.forEach(System.out::println);
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.println("Precio del producto: ");
                        double precio = sc.nextDouble();
                        System.out.println("Cantidad del producto: ");
                        int stock = sc.nextInt();
                        System.out.println("Categoria del producto: ");
                        for (Categoria c : Categoria.) {}
                    }
            }
        }
    }
}