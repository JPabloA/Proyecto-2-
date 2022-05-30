
package modelo;

import controlador.Controller;
import java.awt.Color;

public class Aliado extends Personaje{
    
    public Aliado(){
        visible = true; // MODIFICAR EN EL FUTURO
        int[] coordenadas = Model.coordenadasVacias();
        fila = coordenadas[0];
        columna = coordenadas[1];
        color = new Color(0,204,0);
    }

}
