package controlador;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton; // Quitar
import javax.swing.JPanel;
import vista.*;
import modelo.*;

public class Controller {
    private int contadorTurnos = 0; // Analizar si debe ir en el constructor
    private View view;
    private Model model;
    
    
    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
        moverPersonaje();
    }
    
    private void moverPersonaje(){
        KeyListener eventoTeclado = new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {}
                
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getExtendedKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        if (Model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 4)){
                            contadorTurnos ++;
                            vista.View.tablero[model.jugador.fila][model.jugador.columna].setBackground(View.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                            model.jugador.fila += 1;
                            vista.View.pintarJugador(model.jugador);
                        }   
                        model.jugador.direccion = "Abajo"; // Simplemente para que quede viendo hacia esa direccion (Como se hacia en juegos antiguos)
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (Model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 2)){
                            contadorTurnos ++;
                            vista.View.tablero[model.jugador.fila][model.jugador.columna].setBackground(View.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                            model.jugador.columna += 1;
                            vista.View.pintarJugador(model.jugador);
                        }   
                        model.jugador.direccion = "Derecha"; // Simplemente para que quede viendo hacia esa direccion (Como se hacia en juegos antiguos)
                        break;
                    case KeyEvent.VK_LEFT:
                        if (Model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 3)){
                            contadorTurnos ++;
                            vista.View.tablero[model.jugador.fila][model.jugador.columna].setBackground(View.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                            model.jugador.columna -= 1;
                            vista.View.pintarJugador(model.jugador);
                        }
                        model.jugador.direccion = "Izquierda"; // Simplemente para que quede viendo hacia esa direccion (Como se hacia en juegos antiguos)
                        break;
                    case KeyEvent.VK_UP:
                        if (Model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 1)){
                            contadorTurnos ++;
                            vista.View.tablero[model.jugador.fila][model.jugador.columna].setBackground(View.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                            model.jugador.fila -= 1;
                            vista.View.pintarJugador(model.jugador);
                        }
                        model.jugador.direccion = "Arriba";
                        break;
                }
                
                if (Model.listaConEspacio()){
                    if (contadorTurnos % 15 == 0){
                        Model.crearNuevoEnemigo();
                        View.pintarPersonaje();
                    }
                }
            }
                
            @Override
            public void keyReleased(KeyEvent e) {}
        };
        view.ventana.addKeyListener(eventoTeclado);
    } 
}

