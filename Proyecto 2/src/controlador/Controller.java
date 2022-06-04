package controlador;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import vista.*;
import modelo.*;

public class Controller {
    private int contadorTurnos = 0; // Analizar si debe ir en el constructor
    private View view;
    private Model model;
    
    
    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
        view.pintarJugador(model.jugador);
        view.pintarPersonaje(model);
        moverPersonaje();
        atacarEnemigo();
    }
    
    private void moverPersonaje(){
        
        KeyListener eventoTeclado = new KeyListener() {
 
            @Override
            public void keyTyped(KeyEvent e) {}
                
            @Override
            public void keyPressed(KeyEvent e) {
                boolean flagMovimiento = false;
                
                if (model.jugador.vida > 0){
                    switch (e.getExtendedKeyCode()) {
                        case KeyEvent.VK_DOWN:
                            if (model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 4, view)){
                                contadorTurnos ++;
                                view.pintarCasillaBase(model.jugador.fila, model.jugador.columna);
                                model.jugador.moverJugador("Abajo", model, view);
                                flagMovimiento = true;
                            }   
                            model.jugador.direccionJugador("Abajo"); // Simplemente para que quede viendo hacia esa direccion (Como se hacia en juegos antiguos)
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 2, view)){
                                contadorTurnos ++;
                                view.pintarCasillaBase(model.jugador.fila, model.jugador.columna);
                                model.jugador.moverJugador("Derecha", model, view);
                                flagMovimiento = true;
                            }   
                            model.jugador.direccionJugador("Derecha"); // Simplemente para que quede viendo hacia esa direccion (Como se hacia en juegos antiguos)
                            break;
                        case KeyEvent.VK_LEFT:
                            if (model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 3, view)){
                                contadorTurnos ++;
                                view.pintarCasillaBase(model.jugador.fila, model.jugador.columna);
                                model.jugador.moverJugador("Izquierda", model, view);
                                flagMovimiento = true;
                            }
                            model.jugador.direccionJugador("Izquierda"); // Simplemente para que quede viendo hacia esa direccion (Como se hacia en juegos antiguos)
                            break;
                        case KeyEvent.VK_UP:
                            if (model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 1, view)){
                                contadorTurnos ++;
                                view.pintarCasillaBase(model.jugador.fila, model.jugador.columna);
                                model.jugador.moverJugador("Arriba", model, view);
                                flagMovimiento = true;
                            }
                            model.jugador.direccionJugador("Arriba");
                            break;   
                    }

                    if (flagMovimiento){
                        model.jugadorEncimaDeAliado(model, view);
                        model.jugadorEncimaDeEnemigo(model, view);
                        model.enemigoMataAliado();
                        if (model.cantidadAliados() < 6){
                            if (contadorTurnos % 10 == 0){
                                model.crearNuevoAliado();
                            }
                        }
                        if (contadorTurnos % 12 == 0){
                            model.crearNuevoEnemigo();
                        }
                      
                        view.pintarJugador(model.jugador);
                        view.pintarPersonaje(model);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "El jugador ha perdido todas su vidas", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
                }
            }
                
            @Override
            public void keyReleased(KeyEvent e) {}
        };
        view.ventana.addKeyListener(eventoTeclado); 
    } 
    
    private void atacarEnemigo(){
        
        KeyListener eventoTeclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
                    model.atacar(view);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };

        view.ventana.addKeyListener(eventoTeclado);
        
    }
}

