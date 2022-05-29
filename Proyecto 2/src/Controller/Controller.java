package Controller;

import View.*;
import Model.*;

public class Controller {
    
    
    public Controller(){
        View juego = new View();
        Jugador jugador = new Jugador();
        Enemigo enemigo1 = new Enemigo();
    }
    
    public static int[] coordenadasVacias(){
        int fila;
        int columna;
        int[] resultado; 
        resultado = new int[2];
        
        while(true){
            fila = (int)(Math.random()*(40-1) + 1);
            columna = (int)(Math.random()*(40-1) + 1);
            
            if (View.tablero[fila][columna].getBackground().equals(View.colorTablero)){
                resultado[0] = fila;
                resultado[1] = columna;
                return resultado;
            }
        }
    }
}
