
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
    
    public static boolean siguienteCasillaVacia(int fila, int columna, int direccion){
       
        // Arriba: 1
        // Derecha: 2
        // Izquierda: 3
        // Abajo: 4
        
        switch (direccion){
        
            case 1:
                if (fila != 0){
                    if (View.tablero[fila-1][columna].getBackground().equals(View.colorTablero)){
                        return true;
                    }
                }
                break;
                 
            
            case 2:
                if (columna != 39){
                    if (View.tablero[fila][columna+1].getBackground().equals(View.colorTablero)){
                        return true;
                    }
                }
                break;
            
            case 3:
                if (columna != 0){
                    if (View.tablero[fila][columna-1].getBackground().equals(View.colorTablero)){
                        return true;
                    }
                }
                break;
            
            case 4:
                if (fila != 39){
                    if (View.tablero[fila+1][columna].getBackground().equals(View.colorTablero)){
                        return true;
                    }
                }
                break;
        }
        return false;
    }
}
