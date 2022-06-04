package modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import vista.View;

public class Jugador {
    public int fila;
    public int columna;
    public int vida;
    public Color color;
    public String direccion;
    // Lista utilizada para almacenar los observadores
    private List<Observer> observadores;  
    
    public Jugador(){
        this.observadores = new ArrayList<>();
        fila = 20;
        columna = 3;
        vida = 9;
        color = new Color(204, 204, 255);
        direccion = "Derecha";
    }
    
    public void moverJugador(String direccion, Model model, View view){
    
        switch (direccion){
        
            case "Abajo":
                fila++;
                break;
                
            case "Arriba":
                fila--;
                break;
                
            case "Derecha":
                columna++;
                break;
                
            case "Izquierda":
                columna--;
                break;
        }
        notificarObservadores(model, view);
    }
    
    public void direccionJugador(String nuevaDireccion){
        direccion = nuevaDireccion;
    }
    
    public void aumentarVida(){
        vida ++;
    }
    
    public void disminuirVida(){
        vida--;
    }
    
    public void agregarObservador(Observer observador){
        observadores.add(observador);
    }
    
    public void eliminarObservador(Observer observador){
        observadores.remove(observador);
    }
    
    public void notificarObservadores(Model model, View view){       
        for (Personaje NPC: model.listaNPCs){
            NPC.update(model, view);

        }
   }
}
