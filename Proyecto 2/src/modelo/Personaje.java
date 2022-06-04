
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
    public void moverNPC(String direccion, View vista, Model model){}

    @Override
    public void update(Model model, View view) {
    }

}


