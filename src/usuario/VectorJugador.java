package src.usuario;

import src.juego.*;

public class VectorJugador {

    private Jugador[] jugadores = new Jugador[10];
    private int newJugador;

    public VectorJugador(){
    }

    // Metodo para ingresar jugadores
    public void ingresarJugador(){

        String nombre;

        nombre = IngresoDatos.obtenerLinea("\nIngrese el nombre del jugador: ");
        asignarJugador(nombre);

    }

    // Metodo adicional para ingresar Jugador
    public void asignarJugador(String nombre){
        if (newJugador < 10){
            this.jugadores[newJugador++] = new Jugador(nombre);
        }else {
            IngresoDatos.mostrarMensaje(" Haz alcanzado el maximo de tus jugadores\n");
        }
    }

    // Metodo para mostrar informacion de Jugador
    public void informacionUsuario(){
        for (int i = 0; i < newJugador; i++) {
            System.out.print("Id: "+(i)+" "+jugadores[i].getInformacion());
        }
        System.out.println();
    }

    // Metodo para mostrar informacion por jugador
    public String informacionEspecificaUser(int ident){
        return jugadores[ident].getNombre();
    }

}
