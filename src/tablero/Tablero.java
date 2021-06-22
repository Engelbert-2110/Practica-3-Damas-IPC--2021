package src.tablero;

import src.juego.*;
import src.tablero.*;

public class Tablero {
    private int contadorNegras = 12;
    private int contadorRojas = 12;
    private Celda[][] celdas;

     public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String FNEGRO = "\033[40;30m";
    public static final String FBLANCO = "\033[47;37m";
    public static final String RESET ="\033[0m";


    //Constructor del tablero
    public Tablero(){
        this.celdas = new Celda[8][8]; 
    }


    //Método para Crear Tablero
    public void crearTablero(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (1-(i+j) % 2 == 0){
                    celdas[i][j] = new Celda(true);
                }else {
                    celdas[i][j] = new Celda(false);
                }
            }
        }
    }

    //Método para agregar Fichas
    public void agregarFichas(){
        //fichas rojas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if (1-(i+j) % 2 == 0){
                    celdas[i][j].setFicha(new Ficha(true));
                }
            }
        }

        //fichas verdes
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (1-(i+j) % 2 == 0){
                    celdas[i][j].setFicha(new Ficha(false));
                }
            }
        }
    }



    //Metodo para mostrar el tablero
    public void mostrarTablero(){
        System.out.println(ANSI_YELLOW+ "   0    1     2    3    4     5     6     7   "+ANSI_RESET);
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k<3; k++ ) {
                System.out.print(i+" ");
                for (int j = 0; j < 8; j++) {
                System.out.print(celdas[i][j].pintarCeldas());
            }
            System.out.println();
            }
        }
        System.out.println(ANSI_YELLOW+ "    0     1    2    3    4     5     6     7   "+ANSI_RESET);
        System.out.println("|\n<Columna>\n");
    }

    // Metodo para el movimiento de fichas
    private void moverFichas(int posX, int posY, int indice){
        int posXFin, posYFin;

        if (celdas[posX][posY].isOcupaFicha()){ 
            posXFin = IngresoDatos.opcionMensaje(" Ingrese las coordenadas del movimiento (Fila): ");
            posYFin = IngresoDatos.opcionMensaje(" Ingrese las coordenadas del movimiento (Columna): ");
            if (movimientosPermitidos(posXFin, posYFin)){ 
                if (celdas[posXFin][posYFin].isOcupaFicha()){ 
                    if (comerFicha(posX, posY, posXFin, posYFin)){ 
                        celdas[posXFin][posYFin].setFicha(celdas[posX][posY].getFicha());
                        if (indice == 1) {
                            contadorNegras--;
                            IngresoDatos.mostrarMensaje("\n Ficha verde comida \n");
                        } else if (indice == 2) {
                            contadorRojas--;
                            IngresoDatos.mostrarMensaje("\n  Ficha roja comida  \n");
                        }
                    }else {
                        IngresoDatos.mostrarMensaje("\n Fichas Iguales \n");
                    }
                }else {
                    celdas[posXFin][posYFin].setFicha(celdas[posX][posY].getFicha());
                    IngresoDatos.mostrarMensaje("\n Ficha Movida \n");
                }
            } else {
                IngresoDatos.mostrarMensaje("\n Movimiento Inadecuado \n");
            }
        }else {
            IngresoDatos.mostrarMensaje("\n No existe ficha en posición seleccionada \n");
        }
    }

    // Metodo del tablero dinamico
    public void initTablero(){
        int posX, posY;

        crearTablero();
        agregarFichas();
        mostrarTablero();

        do {
             //Jugador Fichas rojas
             IngresoDatos.mostrarMensaje("\n Jugador 1: (Rojas)\n");
            posX = IngresoDatos.opcionMensaje(" Coordenadas actuales (Filas): ");
            posY = IngresoDatos.opcionMensaje(" Coordenadas actuales (Columna): ");
            moverFichas(posX, posY, 1);

            mostrarTablero();
             //Jugador Fichas verdes
             IngresoDatos.mostrarMensaje("\n Jugador 2: (Verdes)\n");
            posX = IngresoDatos.opcionMensaje(" Coordenadas actuales (Filas): ");
            posY = IngresoDatos.opcionMensaje(" Coordenadas actuales (Columna): ");
            moverFichas(posX, posY, 2);

            mostrarTablero();

        }while (contadores()!= 1);

    }

    // Metodo para movimientos permitidos
    private boolean movimientosPermitidos(int posXFin, int posYFin){
        boolean permitido = false;

        if (1-(posXFin + posYFin) % 2 == 0){
            permitido = true;
        }
        return permitido;
    }

    // Metodo que verifica comer ficha
    private boolean comerFicha(int posX, int posY, int posXFin, int posYFin){
        boolean comer = true;

        if (celdas[posXFin][posYFin].equals(celdas[posX][posY])){
            comer = false;
        }
        return comer;   
    }

    // Muestra resultado final del tablero
    public void muestraTablero(){
        crearTablero();
        agregarFichas();
        mostrarTablero();
    }

    public int contadores(){
        return (contadorRojas == 0 || contadorNegras == 0) ? 1 : 0;
    }

}