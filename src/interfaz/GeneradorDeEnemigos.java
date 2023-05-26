package interfaz;

import java.util.Random;
import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;
public class GeneradorDeEnemigos {


	    public static Enemigos generarEnemigoAleatorio() {
	        Random random = new Random();
	        int tipo = random.nextInt(4);
	        float gravedad = random.nextFloat()* 300 + 100; 
	        float gravedad1 = random.nextFloat()* 800 + 100;
	        switch (tipo) {
	            case 0:
	                return new Metioritos("Lluvia de meteoritos acercándose", 200, random.nextInt(200) + 1, 50,gravedad);
	            case 1:
	                return new Planeta("Planeta está obstruyendo", 200, random.nextInt(300) + 100, 200,gravedad);
	            case 2:
	                return new PlanetaVida("Planeta con vida obstruyendo", 50001, random.nextInt(5001) + 1,20000,gravedad1);
	            case 3:
	                return new AgujeroNegro("Aproximándose a agujero negro", random.nextInt(350) + 150, random.nextInt(500) + 1, 400,gravedad);
	            default:
	                return null;
	        }
	    }}

 /*   public static Enemigos generarMetioritosAleatorio() {
        String nombre = "lluvia de metioritos acercandose";
        int daño = 200;
        Random random = new Random();
        int tamaño = random.nextInt(200) + 1;
        int vida = 50;
        
        return new Metioritos(nombre, daño, tamaño, vida);
    }

    public static Enemigos generarPlanetaAleatorio() {
        String nombre = "Planeta esta osbtruyendo";
        int daño = 200;
        Random random = new Random();
        int tamaño = random.nextInt(300) + 100;
        int vida = 200;
        return new Planeta(nombre, daño, tamaño, vida);
    }

    public static  Enemigos generarPlanetaVidaAleatorio() {
        String nombre = "Planeta con vida obstryuendo";
        int daño = 10000;
        Random random = new Random();
        int tamaño = random.nextInt(300) + 1;
        int vida =500000;
        return new PlanetaVida(nombre, daño, tamaño, vida);
    }

    public static Enemigos generarAgujeroNegroAleatorio() {
        String nombre = "aproximandose a Agujero Negro";
        Random random = new Random();
        int daño = random.nextInt(350) + 150;
        int tamaño = random.nextInt(500) + 1;
        int vida = 400 ;
        return new AgujeroNegro(nombre,daño,tamaño,vida);
        		}*/

