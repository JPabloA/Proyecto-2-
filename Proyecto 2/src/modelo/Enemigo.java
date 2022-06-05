package modelo;

import java.awt.Color;

public class Enemigo extends Personaje{
    public Enemigo(int fila, int columna){
        visible = true;
        this.fila = fila;
        this.columna = columna;
        color = new Color(153,0,76);
    }
    
    public void moverNPC(String direccion, Model model) {
        switch (direccion){

            case "up":
                if(model.siguienteCasillaVaciaOJugador(fila, columna, 1)){
                    fila -= 1;
                }
                break;
            case "down":
                if(model.siguienteCasillaVaciaOJugador(fila, columna, 4)){
                    fila += 1; 
                }
                break;
            case "right":
                if(model.siguienteCasillaVaciaOJugador(fila, columna, 2)){
                    columna += 1;    
                }
                break;
            case "left":
                if(model.siguienteCasillaVaciaOJugador(fila, columna, 3)){
                    columna -= 1;
                }
                break;
        }
    }

    @Override
    public void update(Model model) {
        
        int numRand = (int)(Math.random()*(3-1)+1);
        if (numRand == 1){
            if (fila < model.jugador.fila){
                moverNPC("down", model);
            }
            else if (fila > model.jugador.fila){
                moverNPC("up", model);
            }
        }
        else{
            if (columna < model.jugador.columna){
                moverNPC("right", model);
            }
            else if (columna > model.jugador.columna){
                moverNPC("left", model);
            }
        }
    }
}
