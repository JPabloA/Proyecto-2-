
package modelo;


import java.util.ArrayList;
import java.util.List;
import vista.View;

public class Model {
    public Jugador jugador;
    public List<Personaje> listaNPCs; 
    
    
    public Model(){ 
        listaNPCs = new ArrayList<>();
        iniciarJuego();
    }
    
    public void iniciarJuego(){
        jugador = new Jugador();
        Personaje personajeCreado;
        
        // Enemigos
        for (int i = 0; i < 10; i++ ){
            
            Factory NPC = new Factory();
            int[] coordenadas;
            coordenadas = coordenadasVacias();
            
            if (i < 5){
                //System.out.println("Fila " + coordenadas[0] + "Columna " + coordenadas[1]);
                personajeCreado = NPC.crearPersonaje(coordenadas[0], coordenadas[1], 1);
                listaNPCs.add(personajeCreado);
                jugador.agregarObservador(personajeCreado);
            }
            else{
                //System.out.println("Fila " + coordenadas[0] + "Columna " + coordenadas[1]);
                personajeCreado = NPC.crearPersonaje(coordenadas[0], coordenadas[1],2);
                listaNPCs.add(personajeCreado);
                jugador.agregarObservador(personajeCreado);
            }
        }
    }
    public void printLista(){
    
        for (Personaje NPC: listaNPCs){
            System.out.println(NPC);
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
    
    public boolean siguienteCasillaVacia(int fila, int columna, int direccion){
       
        // Arriba: 1
        // Derecha: 2
        // Izquierda: 3
        // Abajo: 4

        switch (direccion){

            case 1:
                if (fila != 0){
                    if (!enemigoEnCasilla(fila-1, columna)){
                        return true;
                    }
                }
                break;


            case 2:
                if (columna != 39){
                    if (!enemigoEnCasilla(fila, columna+1)){
                        return true;
                    }
                }
                break;

            case 3:
                if (columna != 0){
                    if (!enemigoEnCasilla(fila, columna-1)){
                        return true;
                    }
                }
                break;

            case 4:
                if (fila != 39){
                    if (!enemigoEnCasilla(fila+1, columna)){
                        return true;
                    }
                }
                break;
        }
        return false;
    }
    
    public boolean siguienteCasillaVaciaOJugador(int fila, int columna, int direccion){

    // Arriba: 1
    // Derecha: 2
    // Izquierda: 3
    // Abajo: 4
    
        for (Personaje personaje: listaNPCs){

            switch (direccion){

                case 1:
                    if (fila != 0){
                        if (personaje.visible && fila - 1 == personaje.fila && columna == personaje.columna){ // Aqui
                            return false;
                        }
                    }
                    break;


                case 2:
                    if (columna != 39){
                        if (personaje.visible && fila == personaje.fila && columna + 1 == personaje.columna){
                            return false;
                        }
                    }
                    break;

                case 3:
                    if (columna != 0){
                        if (personaje.visible && fila == personaje.fila && columna - 1 == personaje.columna){
                            return false;
                        }
                    }
                    break;

                case 4:
                    if (fila != 39){
                        if (personaje.visible && fila + 1 == personaje.fila && columna == personaje.columna){
                            return false;
                        }
                    }
                    break;
            }
        }
        return true;
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
         
        for (int i =0; i < listaNPCs.size(); i++){
            Personaje personaje = listaNPCs.get(i);
            if (personaje instanceof Enemigo){
                if (personaje.fila == fila && personaje.columna == columna){
                    vista.pintarCasillaBase(personaje.fila, personaje.columna);
                    listaNPCs.remove(personaje);
                    jugador.eliminarObservador(personaje);
                }
            }
        }
    }
    
    private boolean casillaVacia(int fila, int columna){
    
        for (Personaje personaje: listaNPCs){
            if (personaje.fila == fila && personaje.columna == columna){
                return false;
            }
        }
        return true;
    }
    
    private boolean enemigoEnCasilla(int fila, int columna){
        for (Personaje enemigo: listaNPCs){
            if(enemigo instanceof Enemigo){
                if (fila == enemigo.fila && columna == enemigo.columna){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void crearNuevoEnemigo(){

        Factory NPC = new Factory();
        int[] coordenadas;
        coordenadas = coordenadasVacias();
        
        Personaje personaje = NPC.crearPersonaje(coordenadas[0], coordenadas[1],2);
        listaNPCs.add(personaje);
        jugador.agregarObservador(personaje);
    }
    
    public void crearNuevoAliado(){
        
        Factory NPC = new Factory();
        int[] coordenadas;
        coordenadas = coordenadasVacias();
        
        listaNPCs.add(NPC.crearPersonaje(coordenadas[0], coordenadas[1],1));
    }
    
    public int cantidadAliados(){
        int cantidad = 0;
        
        for (Personaje personaje: listaNPCs){
            if (personaje instanceof Aliado){
               cantidad++;
            }
        }
        return cantidad;
    }
    
    // Regenerar vida de jugador
    public void jugadorEncimaDeAliado(Model model, View view){
        
        for (int i =0; i < listaNPCs.size(); i++){
            Personaje personaje = listaNPCs.get(i);
            if (personaje instanceof Aliado){
                if (jugador.fila == personaje.fila && jugador.columna == personaje.columna){
                    if (jugador.vida < 9){
                        jugador.aumentarVida();
                        view.cambiarImagenVida(model.jugador.vida);
                    }
                    listaNPCs.remove(personaje);
                    jugador.eliminarObservador(personaje);
                } 
            }  
        }
    }
    
    public void jugadorEncimaDeEnemigo(Model model, View view){
        
        for (int i =0; i < listaNPCs.size(); i++){
            Personaje personaje = listaNPCs.get(i);
            if (personaje instanceof Enemigo){
                if (jugador.fila == personaje.fila && jugador.columna == personaje.columna){
                    view.pintarCasillaBase(personaje.fila, personaje.columna);
                    jugador.disminuirVida(); // Le quita una vida al jugador
                    view.cambiarImagenVida(jugador.vida);
                    listaNPCs.remove(personaje);
                    jugador.eliminarObservador(personaje);      
                } 
            }  
        }
    }
    
    public void despintarEnemigos(View view){
        for (Personaje enemigo: listaNPCs){
            if (enemigo instanceof Enemigo){
                view.pintarCasillaBase(enemigo.fila, enemigo.columna);
            }
        }
    }
    
    
    // Quitar vida de jugador
    // D: Funcion utilizada principalmente para aumentar un poco la dificultad del juego
    // Lo que hace es que si se entra al rango de vista un aliado y hay una amenaza justamente en la casilla en donde se encuentra el aliado la amenaza mata al aliado.
    // Se hace esto con la finalidad de que el juego sea un poco mas complicado y tactico.
    
    public void enemigoMataAliado(){
    
        for (int i =0; i < listaNPCs.size(); i++){
            Personaje enemigo = listaNPCs.get(i);
            if (enemigo instanceof Enemigo){  
                for (int x = 0; x < listaNPCs.size(); x++){
                    Personaje aliado = listaNPCs.get(x);
                    if (aliado instanceof Aliado){
                        if (aliado.visible){
                            if (enemigo.fila == aliado.fila  && enemigo.columna == aliado.columna){
                                listaNPCs.remove(aliado);
                                jugador.eliminarObservador(aliado);
                            }
                        }
                    }
                }
            }
        }
    }
    
}
