
package modelo;

import java.awt.Color;
import vista.View;

public class Personaje implements Observer {
    public int fila;
    public int columna;
    public Color color;
    public boolean visible;
    
    public Personaje(){}
    
    // Funciones 
    
    @Override
    public void update(Model model) {
    }

}


