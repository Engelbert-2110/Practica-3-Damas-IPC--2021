package src.juego;

import java.util.*;

public class IngresoDatos {

    static Scanner entrada = new Scanner(System.in);

    // Metodo para mostrar mensaje
    public static void mostrarMensaje(String mensaje){
        System.out.print(mensaje+" ");
    }

    // Metodo para leer numeros
    public static int opcionMensaje(String mensaje){
        mostrarMensaje(mensaje);
        return entrada.nextInt();
    }

     //Metodo para leer texto
    public static String obtenerLinea(String mensaje){
        mostrarMensaje(mensaje);
        entrada.nextLine();
        return entrada.nextLine();
    }

}