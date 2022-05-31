
package modelo;

import java.awt.Color;
import vista.View;
import modelo.Factory;

public class Model {
    public Jugador jugador;
    public Personaje[] listaNPCs; 
    
    
    public Model(){ 
    listaNPCs = new Personaje[16];
    iniciarJuego();
    }
    
    public void iniciarJuego(){
        jugador = new Jugador();
        
        // Enemigos
        for (int i = 0; i < 10; i++ ){
            
            Factory NPC = new Factory();
            int[] coordenadas;
            coordenadas = coordenadasVacias();
            
            if (i < 5){
                System.out.println("Fila " + coordenadas[0] + "Columna " + coordenadas[1]);
                listaNPCs[i] = NPC.crearPersonaje(coordenadas[0], coordenadas[1], 1);
            }
            else{
                System.out.println("Fila " + coordenadas[0] + "Columna " + coordenadas[1]);
                listaNPCs[i] = NPC.crearPersonaje(coordenadas[0], coordenadas[1],2);
            }
        }
    }
    
    public int[] coordenadasVacias(){
    int fila;
    int columna;
    int[] resultado; 
    resultado = new int[2];
        
        while(true){
            fila = (int)(Math.random()*(40-1) + 1);
            columna = (int)(Math.random()*(40-1) + 1);
            
            if (casillaVacia(fila, columna) && (jugador.fila != fila && jugador.columna != columna)){
                resultado[0] = fila;
                resultado[1] = columna;
                return resultado;
            }
        }
    }
    
    public boolean siguienteCasillaVacia(int fila, int columna, int direccion, View vista){
       
        // Arriba: 1
        // Derecha: 2
        // Izquierda: 3
        // Abajo: 4
        
        switch (direccion){
        
            case 1:
                if (fila != 0){
                    if (vista.tablero[fila-1][columna].getBackground().equals(vista.colorTablero)){
                        return true;
                    }
                }
                break;
                 
            
            case 2:
                if (columna != 39){
                    if (vista.tablero[fila][columna+1].getBackground().equals(vista.colorTablero)){
                        return true;
                    }
                }
                break;
            
            case 3:
                if (columna != 0){
                    if (vista.tablero[fila][columna-1].getBackground().equals(vista.colorTablero)){
                        return true;
                    }
                }
                break;
            
            case 4:
                if (fila != 39){
                    if (vista.tablero[fila+1][columna].getBackground().equals(vista.colorTablero)){
                        return true;
                    }
                }
                break;
        }
        return false;
    }
    
    
    public void atacar(View vista){
    
        if (null != jugador.direccion)switch (jugador.direccion) {
            case "Derecha":
                if (jugador.columna != 39){
                    eliminarEnemigo(jugador.fila, jugador.columna + 1, vista);
                }   break;
            case "Izquierda":
                if (jugador.columna != 0){
                    eliminarEnemigo(jugador.fila, jugador.columna - 1, vista);
                }   break;
            case "Arriba":
                if (jugador.fila != 0){
                    eliminarEnemigo(jugador.fila - 1, jugador.columna, vista);
                }   break;
            case "Abajo":
                if (jugador.fila != 39){
                    eliminarEnemigo(jugador.fila + 1, jugador.columna, vista);
                }   break;
            default:
                break;
        }
    }
    
    private void eliminarEnemigo(int fila, int columna, View vista){
        
        int posicion = 0;
        
        for (Personaje personaje: listaNPCs){
            if (personaje != null){
                if (personaje.fila == fila && personaje.columna == columna){
                    vista.tablero[personaje.fila][personaje.columna].setBackground(vista.colorTablero);
                    personaje = null;
                    listaNPCs[posicion] = null;
                }
            }
            posicion ++;
        }
    }
    
    private void printLista(){
        int contador = 0;
        for (Personaje personaje: listaNPCs){
            System.out.println("Personaje numero " + contador + " direccion " + personaje);
            contador++;
        }
    }
    
    private boolean casillaVacia(int fila, int columna){
    
        for (Personaje personaje: listaNPCs){
            if (personaje != null){
                if (personaje.fila == fila && personaje.columna == columna){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void crearNuevoEnemigo(){
        
        int posicion = 0;
        
        for (Personaje personaje: listaNPCs){
            
            if (personaje == null){
                break;
            }
            posicion++;
        }
        
        Factory NPC = new Factory();
        int[] coordenadas;
        coordenadas = coordenadasVacias();
        
        listaNPCs[posicion] = NPC.crearPersonaje(coordenadas[0], coordenadas[1],2);
    }
    
    public boolean listaConEspacio(){

        for (Personaje personaje: listaNPCs){
            
            if (personaje == null){
                return true;
            }
        }
        
        return false;
    }
}
