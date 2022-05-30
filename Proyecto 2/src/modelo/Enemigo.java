package modelo;

import java.awt.Color;

public class Enemigo extends Personaje{
    public Enemigo(){
        visible = true;
        int[] coordenadas = Model.coordenadasVacias();
        fila = coordenadas[0];
        columna = coordenadas[1];
        color = new Color(153,0,76);
    }
}
