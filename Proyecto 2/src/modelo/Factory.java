package modelo;


public class Factory {
    
    // Constructor
    public Factory(){}
    
    // Metodo que crea instancias de NPCs
    // 1. Aliado
    // 2. Enemigo
    
    public Personaje crearPersonaje(int fila, int columna, int tipo){
    
        switch (tipo){
        
            case 1: 
                return new Aliado(fila, columna);
            
            case 2:
                return new Enemigo(fila, columna);

            default:
                return null;     
        }
    }
}
