
package modelo;

import vista.View;

public class Model {
    public Jugador jugador;
    
    
    public Model(){

    jugador = new Jugador();
    Enemigo enemigo1 = new Enemigo();
    Aliado aliado1 = new Aliado();
        
    View.pintarJugador(jugador);
    View.pintarPersonaje(enemigo1);
    View.pintarPersonaje(aliado1);
    
    
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
