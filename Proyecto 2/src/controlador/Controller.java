package controlador;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
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
                
                switch (e.getExtendedKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        if (model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 4, view)){
                            contadorTurnos ++;
                            view.tablero[model.jugador.fila][model.jugador.columna].setBackground(view.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                            model.jugador.fila += 1;
                            view.pintarJugador(model.jugador);
                            flagMovimiento = true;
                        }   
                        model.jugador.direccion = "Abajo"; // Simplemente para que quede viendo hacia esa direccion (Como se hacia en juegos antiguos)
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 2, view)){
                            contadorTurnos ++;
                            view.tablero[model.jugador.fila][model.jugador.columna].setBackground(view.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                            model.jugador.columna += 1;
                            view.pintarJugador(model.jugador);
                            flagMovimiento = true;
                        }   
                        model.jugador.direccion = "Derecha"; // Simplemente para que quede viendo hacia esa direccion (Como se hacia en juegos antiguos)
                        break;
                    case KeyEvent.VK_LEFT:
                        if (model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 3, view)){
                            contadorTurnos ++;
                            view.tablero[model.jugador.fila][model.jugador.columna].setBackground(view.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                            model.jugador.columna -= 1;
                            view.pintarJugador(model.jugador);
                            flagMovimiento = true;
                        }
                        model.jugador.direccion = "Izquierda"; // Simplemente para que quede viendo hacia esa direccion (Como se hacia en juegos antiguos)
                        break;
                    case KeyEvent.VK_UP:
                        if (model.siguienteCasillaVacia(model.jugador.fila, model.jugador.columna, 1, view)){
                            contadorTurnos ++;
                            view.tablero[model.jugador.fila][model.jugador.columna].setBackground(view.colorTablero);// Despintar Jugador (QUITAR LUEGO)
                            model.jugador.fila -= 1;
                            view.pintarJugador(model.jugador);
                            flagMovimiento = true;
                        }
                        model.jugador.direccion = "Arriba";
                        break;   
                }
                
                if (flagMovimiento){
                    model.moverHaciaPersonaje(view);
                    model.rangoVisibilidad();
                    if (model.listaConEspacio()){
                        if (model.cantidadAliados() < 6){
                            if (contadorTurnos % 10 == 0){
                                model.crearNuevoAliado();
                            }
                        }
                        if (contadorTurnos % 20 == 0){
                            model.crearNuevoEnemigo();
                        }
                    }
                    view.pintarPersonaje(model);
                    view.pintarJugador(model.jugador);
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

