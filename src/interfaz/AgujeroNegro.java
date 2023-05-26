package interfaz;

import java.awt.Color;

public class AgujeroNegro extends Enemigos{
	    public AgujeroNegro(String nombre, int daño, int tamaño, int vida,float gravedad) {
	        super(nombre, daño, tamaño, vida,Color.CYAN,gravedad);
	    }

	    @Override
	    public void atacar() {
	        System.out.println("Agujero Negro atacando...");
	    }
	}


