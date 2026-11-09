package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;

import java.util.Scanner;

public class MainTienda {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AppStore tienda = new AppStore();
        int opcion;

        do {
            System.out.println("\n===== APP STORE =====");
            System.out.println("1. Listar juegos");
            System.out.println("2. Buscar juego");
            System.out.println("3. Agregar juego");
            System.out.println("4. Comprar licencias (reabastecer)");
            System.out.println("5. Vender licencias");
            System.out.println("0. Salir");
            opcion = leerEntero("Elige una opcion: ");

            switch (opcion) {
                case 1 -> listar(tienda);
                case 2 -> buscar(tienda);
                case 3 -> agregar(tienda);
                case 4 -> comprar(tienda);
                case 5 -> vender(tienda);
                case 0 -> System.out.println("Hasta pronto.");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void listar(AppStore tienda) {
        boolean hay = false;
        for (Juego j : tienda.getJuegos()) {
            if (j != null) {
                System.out.println(j);
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay juegos registrados.");
        }
    }

    private static void buscar(AppStore tienda) {
        String nombre = leerTexto("Nombre del juego: ");
        Juego j = tienda.buscarJuego(nombre);
        System.out.println(j != null ? j : "Juego no encontrado.");
    }

    private static void agregar(AppStore tienda) {
        String nombre = leerTexto("Nombre: ");
        String categoria = leerTexto("Categoria: ");
        int memoria = leerEntero("Memoria (MB): ");
        double precio = leerDouble("Precio: ");
        int licencias = leerEntero("Licencias disponibles: ");

        int antes = contar(tienda);
        tienda.agregarJuegos(new Juego(nombre, categoria, memoria, precio, licencias));
        if (contar(tienda) > antes) {
            System.out.println("Juego agregado.");
        } else {
            System.out.println("No se pudo agregar: la tienda esta llena.");
        }
    }

    private static void comprar(AppStore tienda) {
        String nombre = leerTexto("Nombre del juego: ");
        int cantidad = leerEntero("Cantidad a comprar: ");
        if (tienda.comprar(nombre, cantidad)) {
            System.out.println("Compra registrada.");
        } else {
            System.out.println("No se pudo comprar (juego no encontrado o cantidad invalida).");
        }
    }

    private static void vender(AppStore tienda) {
        String nombre = leerTexto("Nombre del juego: ");
        int cantidad = leerEntero("Cantidad a vender: ");
        double total = tienda.vender(nombre, cantidad);
        if (total > 0) {
            System.out.println("Venta realizada. Total: $" + total);
        } else {
            System.out.println("No se pudo vender (juego no encontrado, cantidad invalida o sin licencias).");
        }
    }

    private static int contar(AppStore tienda) {
        int n = 0;
        for (Juego j : tienda.getJuegos()) {
            if (j != null) n++;
        }
        return n;
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero entero valido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(leerTexto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido.");
            }
        }
    }
}