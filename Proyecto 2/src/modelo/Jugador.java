package modelo;

import java.awt.Color;

public class Jugador {
    public int fila;
    public int columna;
    public int vida;
    public Color color;
    public String direccion; 
    
    public Jugador(){
        fila = 20;
        columna = 3;
        vida = 10;
        color = new Color(204, 204, 255);
        direccion = "Derecha";
    }
    
}
