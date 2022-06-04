package modelo;

import java.awt.Color;
import vista.View;

public class Enemigo extends Personaje{
    public Enemigo(int fila, int columna){
        visible = true;
        this.fila = fila;
        this.columna = columna;
        color = new Color(153,0,76);
    }
    
    
     @Override
    public void moverNPC(String direccion, View vista, Model model) {
        switch (direccion){

            case "up":
                if(model.siguienteCasillaVaciaOJugador(fila, columna, 1, vista)){
                    vista.pintarCasillaBase(fila, columna);
                    fila -= 1;
                    vista.tablero[fila][columna].setBackground(color);
                }
                break;
            case "down":
                if(model.siguienteCasillaVaciaOJugador(fila, columna, 4, vista)){
                    vista.pintarCasillaBase(fila, columna);
                    fila += 1; 
                    vista.tablero[fila][columna].setBackground(color);
                }
                break;
            case "right":
                if(model.siguienteCasillaVaciaOJugador(fila, columna, 2, vista)){
                    vista.pintarCasillaBase(fila, columna);
                    columna += 1;   
                    vista.tablero[fila][columna].setBackground(color);  
                }
                break;
            case "left":
                if(model.siguienteCasillaVaciaOJugador(fila, columna, 3, vista)){
                    vista.pintarCasillaBase(fila, columna);
                    columna -= 1;
                    vista.tablero[fila][columna].setBackground(color);
                }
                break;
        }
    }

    @Override
    public void update(Model model, View view) {
        
        if (fila < model.jugador.fila){
            moverNPC("down", view, model);
        }
        else if (fila > model.jugador.fila){
            moverNPC("up", view, model);
        }
        else if (columna < model.jugador.columna){
            moverNPC("right",  view,model);

        }
        else if (columna > model.jugador.columna){
            moverNPC("left",  view, model);
        }
    }
}
