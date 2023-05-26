package interfaz;

import java.awt.Color;

public class PlanetaVida extends Enemigos {
	    public PlanetaVida(String nombre, int daño, int tamaño, int vida,float gravedad) {
	        super(nombre, daño, tamaño, vida,Color.green,gravedad);
	    }

	    @Override
	    public void atacar() {
	        System.out.println("El planeta presenta vida");
	    }
	}