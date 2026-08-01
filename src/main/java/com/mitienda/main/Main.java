package com.mitienda.main;

import com.mitienda.model.Categoria;
import com.mitienda.model.Producto;
import com.mitienda.service.TiendaService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TiendaService service = new TiendaService();

        System.out.println("--- SISTEMA DE INVENTARIO ---");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nIngresa la opcion que quieras hacer:");
            System.out.println("1) Listar  2) Agregar  3) Vender  4) Salir");
            System.out.print("Opcion: ");

            int opcion;
            try {
                opcion = sc.nextInt();
                sc.nextLine(); // FIX: limpia el "\n" que queda pendiente tras nextInt()
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingresa un numero valido.");
                sc.nextLine(); // descarta la entrada invalida
                continue;
            }

            switch (opcion) {
                case 1: {
                    List<Producto> lista = service.obtenerCatalogo();
                    if (lista.isEmpty()) {
                        System.out.println("No se encontro el catalogo.");
                    } else {
                        lista.forEach(System.out::println);
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.print("Nombre del producto: ");
                        String nombre = sc.nextLine();

                        System.out.print("Precio del producto: ");
                        double precio = Double.parseDouble(sc.nextLine());

                        System.out.print("Cantidad del producto: ");
                        int stock = Integer.parseInt(sc.nextLine());

                        System.out.println("Categoria del producto:");
                        Categoria[] categorias = Categoria.values();
                        for (int i = 0; i < categorias.length; i++) {
                            System.out.println((i + 1) + ") " + categorias[i]);
                        }
                        System.out.print("Elige una opcion: ");
                        int catOpcion = Integer.parseInt(sc.nextLine());

                        Categoria categoria;
                        if (catOpcion >= 1 && catOpcion <= categorias.length) {
                            categoria = categorias[catOpcion - 1];
                        } else {
                            System.out.println("Opcion invalida, se asigna categoria OTRO.");
                            categoria = Categoria.OTRO;
                        }

                        Producto nuevo = new Producto(nombre, precio, stock, categoria);
                        service.registrarProducto(nuevo);

                    } catch (NumberFormatException e) {
                        System.out.println("Dato numerico invalido. Operacion cancelada.");
                    }
                    break;
                }
                case 3: {
                    try {
                        System.out.print("ID del producto a vender: ");
                        int idProducto = Integer.parseInt(sc.nextLine());

                        System.out.print("Cantidad a vender: ");
                        int cantidad = Integer.parseInt(sc.nextLine());

                        service.procesarVenta(idProducto, cantidad);

                    } catch (NumberFormatException e) {
                        System.out.println("Dato numerico invalido. Operacion cancelada.");
                    }
                    break;
                }
                case 4: {
                    running = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                }
                default:
                    System.out.println("Opcion invalida, intenta de nuevo.");
            }
        }

        sc.close();
    }
}
