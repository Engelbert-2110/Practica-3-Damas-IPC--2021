package src.juego;

import src.tablero.*;
import src.usuario.*;


public class Juego {

    private Tablero damas = new Tablero();
    private VectorJugador usuarios = new VectorJugador();
    String ganador = "";

    public Juego(String juego){
        System.out.println(juego+"\n");
        initJuego();
    }

    private void initJuego() {
        int opcion;
        System.out.println("\nBIENVENIDO AL JUEGO DE DAMAS");

        do {
            System.out.println("\n");
            System.out.println("---------------");
            System.out.println("|     MENU     |");
            System.out.println("---------------");
            System.out.println("1. Jugar Damas Chinas ");
            System.out.println("2. Ingresar Jugadores ");
            System.out.println("3. Mostrar Jugadores  ");
            System.out.println("4. Estadisticas de Juego");
            System.out.println("5. Salir");
            opcion = IngresoDatos.opcionMensaje("Elige una opcion:" );

            switch (opcion){
                case 1:
                     System.out.println("\nJugar Damas Chinas\n"); 
                      jugarDamas();
                     break;

                case 2: 
                     System.out.println("\nIngresar Jugadores\n"); 
                     usuarios.ingresarJugador();
                     break; 

                case 3: 
                     System.out.println("\nInformacion Jugadores\n"); 
                     usuarios.informacionUsuario();
                     break; 

                case 4: 
                     System.out.println("\nMostrar Jugadores\n"); 
                     damas.initTablero();
                     break;

                case 5: 
                     System.out.println("\n Fin del juego\n");
                     break;

                default:
                     System.out.println("\nOpción seleccionada inválida\n");
                     break;
            }

        }while (opcion != 5);
    }

    // Metodo para jugar 
    public void jugarDamas() {
        int idJugadorNo1, idJugadorNo2;
        int revancha;

        do {

            IngresoDatos.mostrarMensaje(" Digite ID de los Jugadores Ingresados \n");
            idJugadorNo1 = IngresoDatos.opcionMensaje("ID Jugador No 1: ");
            IngresoDatos.mostrarMensaje(usuarios.informacionEspecificaUser(idJugadorNo1));


            idJugadorNo2 = IngresoDatos.opcionMensaje("\nID Jugador No 2: ");
            IngresoDatos.mostrarMensaje(usuarios.informacionEspecificaUser(idJugadorNo2)+"\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            IngresoDatos.mostrarMensaje("\n\n JUEGO PPT \n");
            piedraPapelTijeras();
            if(ganador.equals("Ganador jugador1")){
                IngresoDatos.mostrarMensaje("\n\nPor haber ganado, el jugador " + usuarios.informacionEspecificaUser(idJugadorNo1)+ " mueve primero\n\n");
                IngresoDatos.mostrarMensaje("\n\n* "+usuarios.informacionEspecificaUser(idJugadorNo1)+" Jugador 1: Fichas Rojas\n");
                IngresoDatos.mostrarMensaje("\n\n* "+usuarios.informacionEspecificaUser(idJugadorNo2)+" Jugador 2: Fichas Verdes \n\n");
            }
            if(ganador.equals("Ganador jugador2")){
                IngresoDatos.mostrarMensaje("\n\nPor haber ganado, el jugador " + usuarios.informacionEspecificaUser(idJugadorNo2)+ " mueve primero\n\n");
                IngresoDatos.mostrarMensaje("\n\n* "+usuarios.informacionEspecificaUser(idJugadorNo2)+" Jugador 2: Fichas Rojas\n");
                IngresoDatos.mostrarMensaje("\n\n* "+usuarios.informacionEspecificaUser(idJugadorNo1)+" Jugador 1: Fichas Verdes \n\n");

            }

            damas.initTablero();

            revancha = IngresoDatos.opcionMensaje("\n ¿Desea jugar nuevamente?" +
                                "\t1 = SI         2 = NO: ");

        }while (revancha!=2);
    }

    //Metodo juego piedra papel o tijeras
    public String piedraPapelTijeras(){
        int opcionJ1, opcionJ2;

        do {

            IngresoDatos.mostrarMensaje("\n Jugador 1: \n");
            opcionJ1 = IngresoDatos.opcionMensaje("1. Piedra\n 2. Papel\n 3. Tijeras\n - Opcion: ");
            IngresoDatos.mostrarMensaje("\n Jugador 2\n");
            opcionJ2 = IngresoDatos.opcionMensaje("1. Piedra\n 2. Papel\n 3. Tijeras\n - Opcion: ");

            if(opcionJ1 == 1 && opcionJ2 == 1 || opcionJ1 == 2 && opcionJ2 == 2 || opcionJ1 == 3 && opcionJ2 == 3){
                IngresoDatos.mostrarMensaje("\nES UN EMPATE\n");
                
                
                ganador = "Empate";
            } else if(opcionJ1 == 2 && opcionJ2 == 1 || opcionJ1 == 3 && opcionJ2 == 2 || opcionJ1 == 1 && opcionJ2 == 3){
                IngresoDatos.mostrarMensaje("\nEL JUGADOR 2 PERDIO\n");
                IngresoDatos.mostrarMensaje("\n\nEL GANADOR ES JUGADOR 1\n\n");
                ganador = "Gano J1";
            } else if(opcionJ1 == 1 && opcionJ2 == 2 || opcionJ1 == 2 && opcionJ2 == 3 || opcionJ1 == 3 && opcionJ2 == 1){
                IngresoDatos.mostrarMensaje("\nEL JUGADOR 1 PERDIO\n  ");
                IngresoDatos.mostrarMensaje("\n\nEL GANADOR ES JUGADOR 2\n\n");
                ganador = "Gano J2";
            }

        }while (ganador.equals("EMPATE\n"));

        return ganador;
    }

}