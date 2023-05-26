package interfaz;

import javax.swing.JOptionPane;

public class finjuego {             

    private VentanaJuego ventanaJuego;
    private boolean seguirJugando;

    public finjuego(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
        this.seguirJugando = true;
    }

    public void verificarNaveDestruida(Nave nave) {
        if (nave.getcantidadBalas() <= 0 || nave.getcantidadCapsulas() <= 0) {
            seguirJugando = false;
            JOptionPane.showMessageDialog(ventanaJuego, "Tu nave ha sido destruida. Juego terminado.");
            ventanaJuego.dispose();
            System.exit(0);
        }
    }    
        public void verificarNavecompletada(Nave nave) {
	        if ( 10 <= nave.getcantidadObjetosInteres() && 15 <= nave.getcantidaddeenemigosdestruidos() ) {
	            seguirJugando = false;
	            System.out.println("!Haz llegado a marte felicidades piloto!");
	            System.exit(0);

    }
 }
}