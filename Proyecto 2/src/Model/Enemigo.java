package Model;

import java.awt.Color;
import Controller.Controller;
import View.View;

public class Enemigo {
    int fila;
    int columna;
    Color color;
    
    public Enemigo(){
        int[] coordenadas = Controller.coordenadasVacias();
        fila = coordenadas[0];
        columna = coordenadas[1];
        color = new Color(153,0,76);
        pintarEnemigo();
    }
    
    public void pintarEnemigo(){
         View.tablero[fila][columna].setBackground(color);
    }
}
