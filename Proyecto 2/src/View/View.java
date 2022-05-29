package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class View {
    private JFrame ventana;
    private JPanel matriz;
    private JPanel panelBoton;
    private static Color colorFondo = new java.awt.Color(160,160,160);
    public static Color colorTablero = new java.awt.Color(0,102,102);
    public static JButton tablero[][] = new JButton[40][40];
    
    public View(){
        ventana = new JFrame("Proyecto 2");
        matriz = new JPanel();
        panelBoton = new JPanel();
        
        matriz.setLayout(new GridLayout(40,40));
        matriz.setBackground(colorFondo);
        matriz.setBorder(new LineBorder(Color.BLACK));
        ventana.add(matriz);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearTablero();
    }
    
    private void crearTablero(){
        for (int fila = 0; fila < 40; fila++ ){
            for (int columna = 0; columna < 40; columna++){
                tablero[fila][columna] = new JButton();
                tablero[fila][columna].setBounds(10,15,400,400);
                tablero[fila][columna].setBorderPainted(true); // Cambiar luego
                tablero[fila][columna].setBackground(colorTablero);
                matriz.add(tablero[fila][columna]);
                matriz.setVisible(true);
            }
        }
        ventana.setBounds(250, 20, 900, 800);
        matriz.setBounds(300, 300, 600, 720);
        matriz.setBorder(new LineBorder(Color.BLACK));
        ventana.setVisible(true);
        panelBoton.setLayout(new GridLayout(1, 1));
        ventana.add(panelBoton, BorderLayout.SOUTH);
    }
}
