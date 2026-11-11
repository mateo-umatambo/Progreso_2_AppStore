package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.*;
import arreglos.tienda.utilitario.Validacion;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main(){
        int opc;
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1: {
                    ingresarJuegos();
                }break;
                case 2: {
                    System.out.println(tienda.sacarJuegos());
                }break;
                case 3: {

                }break;
                case 4: {

                }break;
                case 5: {
                    vender();
                }break;
                case 6: {

                }break;
                case 7: {
                    System.out.println("Gracias por usar nuestros servicios");
                }break;
                default:
                    System.out.println("No es una opción válida");

            }
    }while (opc != 7);
    }
    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }
    public static void ingresarJuegos(){
        System.out.println("*******Ingreso de datos********");
        String nombre = Validacion.leerString("Ingrese el nombre");
        System.out.print("Ingrese la categoria: ");
        String categoria = Validacion.leerString("Ingrese la categoria");
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());
        if (tienda.agregarJuegos(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))){
            JOptionPane.showMessageDialog(null, "El juego se ha agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "El juego no pudo ser agregado");

        }
    }

    public static void mostrarJuegos(){
        Juego juegos[] = tienda.getJuegos();
        if (tienda.getCont() != -1){
            for (int i = 0; i <= tienda.getCont(); i++){
                System.out.println(juegos[i]);
            }
        }else{
            System.out.println("No hay juegos para mostrar");
        }
    }

    public static void vender(){
        String nombre = Validacion.leerString("Ingrese el nombre del Juego");
        System.out.println("Ingrese la cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        double pago = tienda.vender(nombre, cantidad);
        if (pago > 0){
            JOptionPane.showMessageDialog(null, "Juego: " + nombre + "\nCantidad: " + cantidad+ "\nValor a cancelar: " + pago );
        }else{
            JOptionPane.showMessageDialog(null, "No ha sido posible vender el juego " + nombre);
        }
    }
}
