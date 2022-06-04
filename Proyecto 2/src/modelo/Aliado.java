
package modelo;

import java.awt.Color;
import vista.View;

public class Aliado extends Personaje{
    
    public Aliado(int fila, int columna){
        visible = false; 
        this.fila = fila;
        this.columna = columna;
        color = new Color(0,204,0);
    }
    
    
    public void rangoVisibilidad(Model model){
        visible = (model.jugador.fila > fila - 4 && model.jugador.fila < fila + 4) && (model.jugador.columna > columna - 4 && model.jugador.columna < columna + 4);
    }

    @Override
    public void update(Model model, View view) {
        rangoVisibilidad(model);
    }

}
