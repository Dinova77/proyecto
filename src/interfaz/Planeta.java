package interfaz;

import java.awt.Color;

public class Planeta extends Enemigos{
	Color cafeIntenso = new Color(51, 25, 0);
	    public Planeta(String nombre, int daño, int tamaño, int vida,float gravedad) {
	        super(nombre, daño, tamaño, vida,Color.ORANGE,gravedad);
	    }

	    @Override
	    public void atacar() {
	        System.out.println("Planeta obstruyendo no presenta vida...");
	    }
	}
