import controlador.Controller;
import modelo.Model;
import vista.View;

public class Main {
     public static void main(String[] args) {
         View view = new View();
         Model mod = new Model();
         
         Controller simulacion = new Controller(view, mod);  
     }
}
