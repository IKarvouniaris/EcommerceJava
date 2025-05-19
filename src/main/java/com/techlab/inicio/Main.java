package com.techlab.inicio;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        ArrayList<Producto> productos = new ArrayList<>();
        for (;;) {
                System.out.println("""
                Menu principal:
                  1) Agregar producto
                  2) Listar productos
                  3) Buscar/Actualizar producto
                  4) Eliminar producto
                  5) Crear un pedido
                  6) Listar pedidos
                  7) Salir
                  8) hola
                
                Elija una opción:
                """);

            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                entrada.nextLine();
                if (opcion == 7) {
                    System.out.println("Saliendo del programa.");
                    break;
                } else if (opcion >= 1 && opcion <= 6) {
                    System.out.println("Elegiste la opción: " + opcion);
                    if (opcion == 1) {
                        agregarproducto();
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                }
            } else {
                System.out.println("Por favor ingrese un número");
                entrada.nextLine();
            }
        }
    }
    public static void agregarproducto () {
        Scanner entrada = new Scanner(System.in);
        double precio = 0.0;
        boolean precioValido = false, stockValido = false;
        int stock = 0, entrada2 = 0;
        String nombre, descripcion;
        for (;;) {

            System.out.println("Nombre del producto: ");
            nombre = entrada.nextLine();

            System.out.println("Descripcion del producto: ");
            descripcion = entrada.nextLine();

            precioValido = false;
            while (!precioValido) {
                System.out.println("Precio del producto (en decimales): ");
                if (entrada.hasNextDouble()) {
                    precio = entrada.nextDouble();
                    entrada.nextLine();
                    precioValido = true;
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número válido para el precio.");
                    entrada.next();
                }
            }

            stockValido = false;
            while (!stockValido) {
                System.out.println("Stock del producto: ");
                if (entrada.hasNextInt()) {
                    stock = entrada.nextInt();
                    entrada.nextLine();
                    if (stock >= 0) {
                        stockValido = true;
                    } else {
                        System.out.println("Entrada inválida. Por favor, ingrese un stock valido.");

                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero para el stock.");
                    entrada.next();
                }
            }

            Producto nuevoProducto = new Producto(nombre, descripcion ,precio, stock);
            productos.add(nuevoProducto);

            System.out.println("Producto agregado:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Descripción: " + descripcion);
            System.out.println("Precio: " + precio);
            System.out.println("Stock: " + stock);

            System.out.println("Desea cargar otro producto? Presione 1.");
            if (entrada.hasNextInt()) {
                entrada2 = entrada.nextInt();
                entrada.nextLine();
                if (entrada2 != 1){
                    System.out.println("Entrada inválida. Saliendo de la carga de productos.");
                    break;
                }
            } else {
                System.out.println("Entrada inválida. Saliendo de la carga de productos.");
                entrada.next();
                break;
            }

        }
    }

    public static void listarproductos() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Los productos que tenemos listados son:");
        for (Producto producto : productos) {
            producto.mostrarInfo();
            System.out.println("Presione cualquier tecla para continuar.");
            entrada.next();
        }


    }
    //entrada.close();
}