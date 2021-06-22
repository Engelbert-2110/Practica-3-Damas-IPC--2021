package src.tablero;

public class Celda {


    private boolean color;
    private Ficha ficha;
    private String celda = "█";
    private String celdaColor = "█";

    //colores
    public static final String FNEGRO = "\033[40;30m";
    public static final String FBLANCO = "\033[47;37m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String RESET ="\033[0m";


    

    public Celda(boolean color){
        this.color = color;
        this.ficha = null;
    }

    //Metodo para colorear casillas
    public String pintarCeldas(){
        String casAux = "";
        if (ficha != null) {
            if (color) { 
                casAux =  FBLANCO+celdaColor+celdaColor+ RESET + ficha.obtenerFicha() + FBLANCO+ celdaColor+celdaColor+ RESET ;
            } else { 
                casAux =  FNEGRO +celda +celda+celda+RESET + ficha.obtenerFicha() + FNEGRO +celda+ celda +celda+RESET ;
            }
        }else {
            if (color) { 
                casAux =  FBLANCO+ celdaColor + celdaColor + celdaColor + celdaColor +  celdaColor +RESET ;
            } else { 
                casAux =  FNEGRO + celda+ celda +celda+ celda+ celda +celda +RESET ;
            }
        }
    return casAux;
    }

    
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

     public Ficha getFicha() {
        Ficha aux = this.ficha;
        this.ficha = null;
        return aux;
    }

    public Ficha actual(){
        return this.ficha;
    }

    public boolean isOcupaFicha(){
        return (this.ficha!=null);
    }

   
    public String fichaReina(){
        Ficha aux = this.ficha;
        return AMARILLO+aux+RESET;
    }
}