package controlador;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton; // Quitar
import javax.swing.JPanel;
import vista.*;
import modelo.*;

public class Controller {
    private int contadorTurnos;
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
            public void keyTyped(KeyEvent e) {
            }
                

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN){
                    contadorTurnos ++;
                    vista.View.tablero[model.jugador.fila][model.jugador.columna].setBackground(View.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                    model.jugador.fila += 1;
                    vista.View.pintarJugador(model.jugador);
                }
                else if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT){
                    contadorTurnos ++;
                    vista.View.tablero[model.jugador.fila][model.jugador.columna].setBackground(View.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                    model.jugador.columna += 1;
                    vista.View.pintarJugador(model.jugador);
                }
                else if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT){
                    contadorTurnos ++;
                    vista.View.tablero[model.jugador.fila][model.jugador.columna].setBackground(View.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                    model.jugador.columna -= 1;
                    vista.View.pintarJugador(model.jugador);
                }
                else if (e.getExtendedKeyCode() == KeyEvent.VK_UP){
                    contadorTurnos ++;
                    vista.View.tablero[model.jugador.fila][model.jugador.columna].setBackground(View.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                    model.jugador.fila -= 1;
                    vista.View.pintarJugador(model.jugador);
                }
            }
                

            @Override
            public void keyReleased(KeyEvent e) { 
            }
        };
        view.ventana.addKeyListener(eventoTeclado);
    } 
}

