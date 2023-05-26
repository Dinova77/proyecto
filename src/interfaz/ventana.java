package interfaz;        
import javax.swing.AbstractAction;
import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

 public class ventana extends JFrame{


	    private JTextField textFieldPiloto;
	    private JTextField textFieldNave;


     private JLabel label;

     public ventana() {
         // Configurar el tamaño de la ventana
         setSize(800, 600);

         // Configurar la operación de cierre
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Crear un panel para contener los componentes
         JPanel panel = new JPanel();

         // Crear un componente de etiqueta para mostrar el texto
         label = new JLabel("<html>Las reglas son:<br>"
                 + "1. Si chocas con el enemigo te mostrará las opciones que puedes hacer.<br>"
                 + "2. Si la distancia al objeto es menor que tu tamaño y tu velocidad es mayor que la gravedad del cuerpo celeste, puedes esquivar el objeto.<br>"
                 + "3. Si no, recibirás daño.<br>"
                 + "4. recuerda no puedes atacar a los planetas con vida.<br>"
                 + "5. El juego acaba al recoger 10 objetos y destruir 5 enemigos de cada clase.<br>"
                 + "¡Cuida tus cápsulas!.<br>"
                 + "pulsa espacio para continuar </html>", SwingConstants.CENTER);


         label.setForeground(Color.WHITE);
         panel.add(label);

         // Establecer el color de fondo del panel
         panel.setBackground(Color.BLACK);

         // Agregar el panel a la ventana
         add(panel);
         JLabel labelPiloto = new JLabel("Nombre del piloto:");
         textFieldPiloto = new JTextField(20);
         panel.add(labelPiloto);
         panel.add(textFieldPiloto);

         JLabel labelNave = new JLabel("Nombre de la nave:");
         textFieldNave = new JTextField(20);
         panel.add(labelNave);
         panel.add(textFieldNave);
         // Establecer el color de fondo del panel
         panel.setBackground(Color.BLACK);

         // Agregar el panel a la ventana
         add(panel);

         // Agregar el KeyListener a la ventana para detectar la pulsación de la tecla Espacio
         panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "continue");
         panel.getActionMap().put("continue", new AbstractAction() {
             public void actionPerformed(ActionEvent e) {
                 String piloto = textFieldPiloto.getText();
                 String nombrenave = textFieldNave.getText();

                 VentanaJuego ventanaJuego = new VentanaJuego(piloto,nombrenave);
                 ventanaJuego.setVisible(true);
                 dispose();
             }
         });

         // Establecer el enfoque en la ventana para que pueda detectar eventos de teclado
         setFocusable(true);
     }
    
 }