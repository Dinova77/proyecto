package interfaz;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import interfaz.finjuego;
import interfaz.objetos;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import interfaz.GeneradorDeObjetos;
import interfaz.GeneradorDeEnemigos;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import interfaz.objetos;
import java.util.ArrayList;
import java.util.List;
import interfaz.PlanetaVida;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class VentanaJuego extends JFrame implements ActionListener, KeyListener {
	private Rectangle collisionrombo;
	public  int puntos;
	public  int totalPuntos;
    private Nave nave;
	private Rectangle colision;
    private JPanel panel;
    private int triangleX;
    private int triangleY;
    private int backgroundY;
    private boolean isGameOver;
    private List<Enemigos> enemigos;
    private int circleFallSpeed = 5;
    private static String piloto;
    private static String nombrenave;
    private boolean eventoProcesado = false;
    private Enemigos enemigoColisionado;
    private List<objetos> objetos;
    private finjuego juegoTerminado;
    private int saltocuantico= 5;
    



    public VentanaJuego(String piloto, String nombrenave) {
    	boolean colisionPlanetaConVida = false;
    	objetos = new ArrayList<>();
    	puntos = 0;
    	totalPuntos = 0; 
    	backgroundY = 0;
        isGameOver = false;
        colision = new Rectangle(triangleX - 20, triangleY - 20, 40, 40); // Inicialización de la variable
        enemigos = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Enemigos enemigo = GeneradorDeEnemigos.generarEnemigoAleatorio();
            enemigos.add(enemigo);
            juegoTerminado = new finjuego(this);

        }
        
        for (int i = 0; i < 50; i++) {
            objetos objeto = GeneradorDeObjetos.generarObjetoAleatorio();
            objetos.add(objeto);
        }

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar la operación de cierre
        setResizable(false);
        setLocationRelativeTo(null);
        // Crear un panel para contener los componentes
        nave = new Nave( piloto,nombrenave,10000, 2000, 0);
        nave.actualizarValoresAleatorios();
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTriangle(g);
                drawBackground(g);
                drawRhombs(g);
                
            }
 
        };
        panel.setBackground(Color.BLACK);

        // Agregar el panel a la ventana
        add(panel);

        // Inicializar la posición del triángulo
        triangleX = getWidth() / 2;
        triangleY = getHeight() / 2;

        // Agregar el KeyListener a la ventana para detectar las pulsaciones de teclas
        addKeyListener(this);

        // Establecer el enfoque en la ventana para que pueda recibir eventos de teclado
        setFocusable(true);
        finjuego juegoTerminado = new finjuego(this);
        juegoTerminado.verificarNaveDestruida(nave);

    }
  

    private void moveTriangle(int deltaX, int deltaY) {
        // Ajustar la velocidad de movimiento aumentando el valor de deltaX y deltaY
        int speed = 5; // Velocidad de movimiento
        triangleX += deltaX * speed;
        triangleY += deltaY * speed;
        

        // Actualizar las coordenadas de la caja de colisión del triángulo
        colision.setLocation(triangleX - 20, triangleY - 20);
        repaint(); // Vuelve a dibujar la ventana
    }
       
    

    private void moveBackground(int deltaY) {
        // Ajustar la velocidad de movimiento aumentando el valor de deltaY
        int speed = 2; // Velocidad de movimiento
        backgroundY += deltaY * speed;
        repaint(); // Vuelve a dibujar la ventana
    }

    private void drawTriangle(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Crear un triángulo con vértices en las coordenadas (x, y) especificadas
        int[] xPoints = {triangleX, triangleX - 20, triangleX + 20};
        int[] yPoints = {triangleY - 20, triangleY + 20, triangleY + 20};
        int numPoints = 3;

        // Establecer el color del triángulo
        g2d.setColor(Color.YELLOW);

        // Dibujar el triángulo
        g2d.fillPolygon(new Polygon(xPoints, yPoints, numPoints));
     // Crear cajas de colisión para el triángulo
        Rectangle colision = new Rectangle(triangleX - 20, triangleY - 20, 40, 40);
        
        // Guardar el estado gráfico actual
        Composite originalComposite = g2d.getComposite();

        // Crear una nueva instancia de AlphaComposite para establecer la transparencia
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC);
        
        // Establecer la transparencia en el rectángulo de colisión
        g2d.setComposite(alphaComposite);

        // Dibujar el rectángulo de colisión transparente
        g2d.setColor(new Color(0, 0, 0, 0));   // Color transparente
        g2d.draw(colision);

       // Restaurar el estado gráfico original
        g2d.setComposite(originalComposite);

    }

    private void drawRhombs(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int numRhombs = 25;
        List<Rectangle> rombos = new ArrayList<>();
        List<objetos> objetosRombos = new ArrayList<>();

        for (int i = 0; i < numRhombs; i++) {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            int size = (int) (Math.random() * 20) + 10; // Tamaño aleatorio entre 10 y 20


            Rectangle collisionRhombo = new Rectangle(x, y, size, size);
            rombos.add(collisionRhombo); // Agregar el rombo a la lista

            objetos objeto = GeneradorDeObjetos.generarObjetoAleatorio(); // Generar un objeto aleatorio
            objetosRombos.add(objeto);
            
            drawRhomus(g2d, x, y, size);

            // Dibujar el rectángulo de colisión
            g2d.setColor(new Color(5, 0, 0, 0)); // Color transparente
            g2d.draw(collisionRhombo);

            boolean collisionDetected = false;

            for (Rectangle rombo1 : rombos) {
                if (!collisionDetected && (rombo1.intersects(colision.getBounds2D()))) {
                    objetos objetos = objetosRombos.get(i); // Reemplaza "objetos1" con el nombre correcto de tu lista
                    nave.actualizarValoresAleatorios();
                    JDialog dialog = new JDialog((JFrame) null, "¡Peligro en camino " + nave.getnombre() + "!", true); // true para que sea modal
                    JPanel contentPane = new JPanel();
                    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
                    JLabel label9 = new JLabel("Piloto: " + nave.getnombrepiloto());
                    JLabel label = new JLabel(objeto.getNombre());
                    JLabel label2 = new JLabel("Gravedad: "  + "                               Distancia al enemigo: " + nave.getdistanciaNaveObjeto());
                    JLabel label3 = new JLabel("Tamaño: " + objeto.gettamaño() + "             Distancia al objeto: " + nave.getdistanciaNaveObjeto());
                    JLabel label4 = new JLabel("                                               Velocidad: " + nave.getvelocidadNave());
                    JLabel label5 = new JLabel("                                               Cápsulas: " + nave.getcantidadCapsulas());
                    JLabel label6 = new JLabel("                                               Balas: " + nave.getcantidadBalas());
                    JLabel label7 = new JLabel("                                               Objetos capturados: " + nave.getcantidadObjetosInteres());
                    JLabel label8 = new JLabel("                                               Enemigos destruidos: " + nave.getcantidaddeenemigosdestruidos());

                    JButton button = new JButton("Aceptar");
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Acciones a realizar cuando se hace clic en el botón "Aceptar"
                        	 dialog.dispose();
                             objetosRombos.remove(objeto);
                         }
                     });
                    JButton button6 = new JButton("atacar"); // Botón extra 3
                    button6.addActionListener(new ActionListener() {
                    	
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String resultadoatacar = atacarobjeto(nave,objetos);
                            Component frame = null;
							JOptionPane.showMessageDialog(frame, resultadoatacar);
							  dialog.dispose();
	                            objetosRombos.remove(objetos);
                        }
                    });
                    JButton button7 = new JButton("esquiva"); // Botón extra 5
                    button7.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	 
                                  String resultadoEsquivar = esquivarobjetos(nave, objeto);
                                  Component frame = null;
								JOptionPane.showMessageDialog(frame, resultadoEsquivar);
								  dialog.dispose();
		                            objetosRombos.remove(objetos);
                        }
                    });
                    JButton button4 = new JButton("recoger"); // Botón extra 4
                    button4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	String resultadorecoger = recogerobjeto(nave, objeto);
                            Component frame = null;
							JOptionPane.showMessageDialog(frame, resultadorecoger);
							  dialog.dispose();
	                            objetosRombos.remove(objetos);  
                        	
                        }
                    });

                    
                     contentPane.add(label9);
                     contentPane.add(label);
                     contentPane.add(label2);
                     contentPane.add(label3);
                     contentPane.add(label4);
                     contentPane.add(label5);
                     contentPane.add(label6);
                     contentPane.add(label7);
                     contentPane.add(label8);
                     contentPane.add(button);
                     contentPane.add(button6);
                     contentPane.add(button4); // Agregar el botón extra 4
                     contentPane.add(button7);
                    dialog.setContentPane(contentPane);
                    dialog.setSize(400, 400);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);

                    // Continuar con el código después de cerrar el diálogo
                }
            }
        }
    }


    private void drawRhomus(Graphics2D g2d, int x, int y, int size) {
        int halfSize = size / 2;

        int[] xPoints = {x, x + halfSize, x, x - halfSize};
        int[] yPoints = {y - halfSize, y, y + halfSize, y};

        g2d.setColor(Color.RED);
        g2d.fillPolygon(xPoints, yPoints, 4);
    }

    
    
    private void drawBackground(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Establecer el color del fondo
        g2d.setColor(Color.BLACK);

        // Dibujar el fondo con círculos aleatorios
        int numCircles = 25; // Número total de círculos
        List<Ellipse2D> circles = new ArrayList<>();
        List<Enemigos> enemigosCirculos = new ArrayList<>();
        boolean collisionDetected = false;
        for (int i = 0; i < numCircles; i++) {
            int circleX = (int) (Math.random() * getWidth()); // Posición X aleatoria
            int circleY = (int) (Math.random() * getHeight()); // Posición Y aleatoria
            int circleSize = (int) (Math.random() * 30) + 10; // Tamaño del círculo aleatorio entre 10 y 40
            Ellipse2D circle = new Ellipse2D.Double(circleX, circleY, circleSize, circleSize);
            circles.add(circle);

            for (Ellipse2D circle1 : circles) {
                if (!collisionDetected && (circle1.intersects(colision.getBounds2D()))){
                	 Enemigos enemigo = enemigos.get(i);
                    nave.actualizarValoresAleatorios();

                    JDialog dialog = new JDialog((JFrame) null, "¡Peligro en camino " + nave.getnombre() + "!", true); // true para que sea modal

                    JPanel contentPane = new JPanel();
                    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
                    JLabel label9 = new JLabel("Piloto: " + nave.getnombrepiloto());
                    JLabel label = new JLabel(enemigo.getNombre() );
                    JLabel label2 = new JLabel("Gravedad: " + enemigo.getgravedad() + "        Distancia al enemigo: " + nave.getdistanciaNaveenemigo());
                    JLabel label3 = new JLabel("Tamaño: " + enemigo.getTamaño() + "                     Distancia al objeto: " + nave.getdistanciaNaveObjeto());
                    JLabel label4 = new JLabel("                                             Velocidad: " + nave.getvelocidadNave());
                    JLabel label5 = new JLabel("                                             Cápsulas: " + nave.getcantidadCapsulas());
                    JLabel label6 = new JLabel("                                             Balas: " + nave.getcantidadBalas());
                    JLabel label7 = new JLabel("                                             Objetos capturados: " + nave.getcantidadObjetosInteres());
                    JLabel label8 = new JLabel("                                             Enemigos destruidos: " + nave.getcantidaddeenemigosdestruidos());

                   
                    JButton button = new JButton("Aceptar");
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Acciones a realizar cuando se hace clic en el botón "Aceptar"
                            dialog.dispose();
                            enemigosCirculos.remove(enemigo); // Eliminar el enemigo correspondiente al círculo colisionado
                            
                            // Continúa con la ejecución después de que se haya cerrado el diálogo
                         
                        }
                    });

                    JButton button2 = new JButton("Salto cuántico");
                    button2.addActionListener(new ActionListener() {
                        @Override
                         public void actionPerformed(ActionEvent e) {
                          String resultadosalto = saltocuantico(nave,enemigo);
                          
                          Component frame = null;
							JOptionPane.showMessageDialog(frame, resultadosalto);
							  dialog.dispose();
	                            enemigosCirculos.remove(enemigo);
                        }
                    });

                    JButton button3 = new JButton("atacar"); // Botón extra 3
                    button3.addActionListener(new ActionListener() {
                    	
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String resultadoatacar = atacar(nave, enemigo);
                            Component frame = null;
							JOptionPane.showMessageDialog(frame, resultadoatacar);
							  dialog.dispose();
	                            enemigosCirculos.remove(enemigo);
                        }
                    });
                    JButton button5 = new JButton("esquiva"); // Botón extra 5
                    button5.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	 
                                  String resultadoEsquivar = esquivar(nave, enemigo);
                                  Component frame = null;
								JOptionPane.showMessageDialog(frame, resultadoEsquivar);
								  dialog.dispose();
		                            enemigosCirculos.remove(enemigo);
                        }
                    });
                    JButton button41 = new JButton("recoger"); // Botón extra 4
                    button41.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	String resultadorecoger = recogerenemigo(nave, enemigo);
                            Component frame = null;
							JOptionPane.showMessageDialog(frame, resultadorecoger);
							  dialog.dispose();
	                            enemigosCirculos.remove(enemigo);  
                        	
                        }
                    });

                

                    contentPane.add(label9);
                    contentPane.add(label);
                    contentPane.add(label2);
                    contentPane.add(label3);
                    contentPane.add(label4);
                    contentPane.add(label5);
                    contentPane.add(label6);
                    contentPane.add(label7);
                    contentPane.add(label8);
                    contentPane.add(button);
                    contentPane.add(button2);
                    contentPane.add(button3); // Agregar el botón extra 3
                    contentPane.add(button41); // Agregar el botón extra 4
                    contentPane.add(button5); // Agregar el botón extra 5
                    dialog.setContentPane(contentPane);
                    
                    dialog.setSize(400,400);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);

                    collisionDetected = true;
            
                
    

                    // Dibujar el círculo con el relleno del color establecido
                    enemigos.remove(enemigo); // Eliminar el enemigo correspondiente al círculo colisionado

   
               }
           
             
                }
      
            Enemigos enemigo = enemigos.get(i);
            g2d.setColor(enemigo.getColor()); // Establecer el color del enemigo al círculo
            g2d.fill(circle);
        }
       
     }


public String saltocuantico(Nave nave,Enemigos enemigo )
{
if (saltocuantico >= 1) {
	saltocuantico= saltocuantico - 1;
	
	return"haz esquivado  el enemigo,te quedan "+saltocuantico;
}else if (saltocuantico <= 0){
	nave.setCantidadCapsulas(nave.getcantidadCapsulas() - enemigo.getDaño());
    juegoTerminado.verificarNaveDestruida(nave);
	return "ya no tienes saltos cuanticos ,te han dañado";
	
}
return"equisde";	
}



	public String esquivar(Nave nave, Enemigos enemigo) {
        if (enemigo.getTamaño() < nave.getdistanciaNaveenemigo()&& nave.getvelocidadNave()> enemigo.getgravedad()*10) {
            puntos += 50;
            totalPuntos += 50;
            juegoTerminado.verificarNavecompletada(nave);
            return "Pudiste esquivar al enemigo, su tamaño era menor que la distancia a la que se encuentra.";
        } else if (enemigo.getTamaño() > nave.getdistanciaNaveenemigo() || nave.getvelocidadNave()< enemigo.getgravedad()*10) {
            nave.setCantidadBalas(nave.getcantidadBalas() - enemigo.getvida());
           nave.setcantidaddeenemigosdestruidos(nave.getcantidaddeenemigosdestruidos() + 1);
            nave.setCantidadCapsulas(nave.getcantidadCapsulas() - enemigo.getvida());
            juegoTerminado.verificarNaveDestruida(nave);
            juegoTerminado.verificarNavecompletada(nave);
            return "¡Has chocado " + enemigo.getvida() + " puntos de daño!";
        } else {
            nave.setCantidadCapsulas(nave.getcantidadBalas() - enemigo.getvida());
            juegoTerminado.verificarNaveDestruida(nave);
            juegoTerminado.verificarNavecompletada(nave);
            return "No pudiste esquivar al enemigo, ¡te han atacado!";
        }
    }
    public String esquivarobjetos(Nave nave,objetos objeto) {
        if (objeto.gettamaño() < nave.getdistanciaNaveObjeto()) {
            puntos += 50;
            totalPuntos += 50;
            return "Pudiste esquivar al enemigo, su tamaño era menor que la distancia a la que se encuentra.";
        } else if (objeto.gettamaño() > nave.getdistanciaNaveenemigo()) {
            nave.setCantidadBalas(nave.getcantidadBalas() - objeto.getvida());
           nave.setcantidaddeenemigosdestruidos(nave.getcantidaddeenemigosdestruidos() + 1);
            nave.setCantidadCapsulas(nave.getcantidadCapsulas() - objeto.getvida());
            juegoTerminado.verificarNaveDestruida(nave);
            juegoTerminado.verificarNavecompletada(nave);
            return "¡Has chocado " + objeto.getvida() + " puntos de daño!";
        } else {
            nave.setCantidadCapsulas(nave.getcantidadBalas() - objeto.getvida());
            return "No pudiste esquivar al enemigo, ¡te han atacado!";
        }
    }
    public String atacar(Nave nave, Enemigos enemigo) {
        if (enemigo.getTamaño() > nave.getdistanciaNaveenemigo() ) {
            nave.setCantidadBalas(nave.getcantidadBalas() - enemigo.getvida());
            puntos += enemigo.getDaño();
            totalPuntos += enemigo.getDaño();
            nave.setcantidaddeenemigosdestruidos(nave.getcantidaddeenemigosdestruidos()+1);
            juegoTerminado.verificarNavecompletada(nave);
            return "¡Has atacado al enemigo y has infligido " + enemigo.getDaño() + " puntos de daño!";
        } else if (enemigo.getTamaño() < nave.getdistanciaNaveenemigo()) {
            nave.setCantidadCapsulas(nave.getcantidadBalas() - enemigo.getvida());
            juegoTerminado.verificarNaveDestruida(nave);
            juegoTerminado.verificarNavecompletada(nave);
            return "¡Estabas demasiado cerca! Has recibido " + enemigo.getvida() + " puntos de daño.";
        } else {
            // Aquí puedes agregar cualquier otra acción o manejo de caso
            return "No pudiste atacar al enemigo.";
        }
    }
    public String atacarobjeto(Nave nave,objetos objeto) {
        if (objeto.gettamaño() > nave.getdistanciaNaveObjeto()) {
            nave.setCantidadBalas(nave.getcantidadBalas() - objeto.getvida());
            puntos += objeto.getvida();
            totalPuntos += objeto.getvida();
            juegoTerminado.verificarNavecompletada(nave);
            nave.setcantidaddeenemigosdestruidos(nave.getcantidaddeenemigosdestruidos() + 1);
            return "¡Has atacado al objeto y has infligido " + objeto.getvida() + " puntos de daño!";
        } else if (objeto.gettamaño() < nave.getdistanciaNaveenemigo()) {
            nave.setCantidadCapsulas(nave.getcantidadBalas() - objeto.getvida());
            juegoTerminado.verificarNaveDestruida(nave);
            juegoTerminado.verificarNavecompletada(nave);
            return "¡Estabas demasiado cerca! Has recibido " + objeto.getvida() + " puntos de daño.";
        } else {
            // Aquí puedes agregar cualquier otra acción o manejo de caso
            return "No pudiste atacar al objeto.";
        }
    } 
    public String recogerenemigo(Nave nave, Enemigos enemigos)
    {
		nave.setCantidadCapsulas(nave.getcantidadCapsulas() + enemigos.getvida());
        juegoTerminado.verificarNaveDestruida(nave);
    return  "no puedes recoger enemigos";
    }
    public String recogerobjeto(Nave nave, objetos objeto)
    {
    	if(objeto.gettamaño() <= nave.getdistanciaNaveObjeto()) {
    		nave.setCantidadBalas(nave.getcantidadBalas() + objeto.getbalas());
    		nave.setCantidadCapsulas(nave.getcantidadCapsulas()+ objeto.getcapsulas());
    		saltocuantico=saltocuantico+1;
    		nave.setcantidadObjetosInteres(nave.getcantidadObjetosInteres()+1);
            juegoTerminado.verificarNaveDestruida(nave);
            juegoTerminado.verificarNavecompletada(nave);
    		return "recogiste " + objeto.getbalas() + " balas," + objeto.getcapsulas()+" capsulas "+" meteria oscura" ;
    	}else if(objeto.gettamaño()>= nave.getdistanciaNaveObjeto()) {
    	return "no habia espacio";
    	}
    return  "arriba las chibas";
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveTriangle(0, -2); // Mover hacia arriba
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveTriangle(0, 2); // Mover hacia abajo
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveTriangle(-2, 0); // Mover hacia la izquierda
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveTriangle(2, 0); // Mover hacia la derecha
        }
    }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    }