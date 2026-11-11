package arreglos.tienda.utilitario;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje){
        String nombre;
        do {
            System.out.print(mensaje + " : ");
            nombre = sc.nextLine();
        }while(nombre == null || nombre.trim().isEmpty());
        return nombre;
    }
}