
package modelo;

import controlador.Controller;
import java.awt.Color;

public class Aliado extends Personaje{
    
    public Aliado(int fila, int columna){
        visible = false; // MODIFICAR EN EL FUTURO
        this.fila = fila;
        this.columna = columna;
        color = new Color(0,204,0);
    }

}
