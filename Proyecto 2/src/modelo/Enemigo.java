package modelo;

import java.awt.Color;

public class Enemigo extends Personaje{
    public Enemigo(int fila, int columna){
        visible = true;
        this.fila = fila;
        this.columna = columna;
        color = new Color(153,0,76);
    }
}
