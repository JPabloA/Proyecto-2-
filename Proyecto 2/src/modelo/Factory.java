package modelo;


public class Factory {
    
    // Constructor
    public Factory(){}
    
    // Metodo que crea instancias de NPCs
    // 1. Aliado
    // 2. Enemigo
    
    public Personaje crearPersonaje(int tipo){
    
        switch (tipo){
        
            case 1: 
                return new Aliado();
            
            case 2:
                return new Enemigo();

            default:
                return null;     
        }
    }
}
