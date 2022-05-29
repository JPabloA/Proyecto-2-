package Model;

import View.View;
import java.awt.Color;

public class Jugador {
    int fila;
    int columna;
    int vida;
    Color color;
    String direccion; 
    
    public Jugador(){
        
        fila = 20;
        columna = 3;
        vida = 10;
        color = new Color(204, 204, 255);
        direccion = "Derecha";
        pintarJugador();
    }
    
    private void pintarJugador(){
        View.tablero[fila][columna].setBackground(color);
    }
    
}
