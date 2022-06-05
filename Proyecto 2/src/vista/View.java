package vista;

import modelo.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class View {
    public JFrame ventana;
    public JPanel matriz;
    public JPanel vidas;
    private static Color colorFondo = new java.awt.Color(160,160,160);
    public Color colorTablero = new java.awt.Color(0,102,102);
    public ImageIcon fullCorazones = new ImageIcon("Images/9 corazones.png");
    public JLabel tablero[][] = new JLabel[40][40];
    public JLabel vidasImage;

    
    public View(){
        ventana = new JFrame("Proyecto 2");
        matriz = new JPanel();
        vidas = new JPanel();
        
        ventana.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.WHITE));
        
        vidasImage = new JLabel(fullCorazones);
        vidas.setLayout(new GridLayout(1,1));
        vidas.setBackground(Color.WHITE);
        vidas.setBorder(new LineBorder(Color.BLACK));
        vidas.add(vidasImage);
  
        ventana.add(vidas, BorderLayout.WEST);
      
        matriz.setLayout(new GridLayout(40,40));
        matriz.setBackground(colorFondo);
        matriz.setBorder(new LineBorder(Color.BLACK));
        ventana.add(matriz, BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearTablero();
    }
    
    private void crearTablero(){
        
        Border BevelRaised = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        
        for (int fila = 0; fila < 40; fila++ ){
            for (int columna = 0; columna < 40; columna++){
                tablero[fila][columna] = new JLabel();
                tablero[fila][columna].setBorder(BevelRaised);
                tablero[fila][columna].setBounds(10,15,400,400);
                tablero[fila][columna].setOpaque(true);
                tablero[fila][columna].setBackground(colorTablero);
                matriz.add(tablero[fila][columna]);
                matriz.setVisible(true);
            }
        }
        ventana.setBounds(250, 20, 900, 800);
        matriz.setBounds(300, 300, 600, 720);
        matriz.setBorder(new LineBorder(Color.BLACK));
        ventana.setVisible(true);
    }
    
    public void pintarPersonaje(Model model){
            
        for (Personaje personaje: model.listaNPCs){
            if (personaje != null){
                if (personaje.visible){
                    tablero[personaje.fila][personaje.columna].setBackground(personaje.color);
                }
                else{
                    tablero[personaje.fila][personaje.columna].setBackground(colorTablero); // Con el fin de eliminar la huella dejada por los aliados
                }
            }
        }
        cambiarImagenVida(model.jugador.vida);
    
    }
    public void pintarJugador(Jugador jugador){
        tablero[jugador.fila][jugador.columna].setBackground(jugador.color);
    }
    
    public void pintarCasillaBase(int fila, int columna){
        tablero[fila][columna].setBackground(colorTablero);
    }
    
    public void cambiarImagenVida(int cantidadVidas){
        
        String extension;
        
        if (cantidadVidas != 1){
            extension = " corazones.png";
        }
        else{
            extension = " corazon.png";
        }
        
        String resultado = "Images/" + Integer.toString(cantidadVidas) + extension;

        ImageIcon imagen = new ImageIcon(resultado);
        vidasImage.setIcon(imagen);
        vidasImage.repaint();  
    }
}
