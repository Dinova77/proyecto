package interfaz;

import java.util.Random;

public class GeneradorDeObjetos {
	public static objetos generarObjetoAleatorio() {
	    Random random = new Random();
	    int tipo = random.nextInt(3);
	    double tamaño = random.nextDouble() * 2 + 1;

	    switch (tipo) {
	        case 0:
	            return new ObjetoClase1("Objeto clase 1 ha aparecido", 20, tamaño,0,50);
	        case 1:
	            return new ObjetoClase2("Objeto clase 2 ha aparecido", 30, tamaño,50,0);
	        case 2:
	            return new ObjetoClase3("Objeto clase 3 ha aparecido", 70, tamaño,50,50);
	        default:
	            return null;
	    }
	}

	
/*	public static objetos generarObjetoClase1Aleatorio() {
	    String nombre = "objeto clase 1 ha aparecido";
	    int vida= 20;
	    Random random = new Random();
        double tamaño  = 1.5 + (0.8) * random.nextDouble();
        tamaño= Math.round(tamaño * 10) / 10.0; // Redondear a un decimal
        return new ObjetoClase1(nombre,vida,tamaño);
	    }
	public static objetos generarObjetoClase2Aleatorio() {
	    String nombre = "objeto clase 2 ha aparecido";
	    int vida= 30;
	    Random random = new Random();
	    double tamaño  = 2 + (double)(Math.random() * 0.5);
        tamaño= Math.round(tamaño * 10) / 10.0; // Redondear a un decimal
	    return new ObjetoClase2(nombre,vida,tamaño);
	    }
	public static objetos generarObjetoClase3Aleatorio() {
	    String nombre = "objeto clase 3 ha aparecido";
	    int vida = 70;
	    Random random = new Random();
	    double tamaño  = 2.5 + (double)(Math.random() * 0.5);
	    tamaño = Math.round(tamaño * 10) / 10.0f; 	    
	    return new ObjetoClase3(nombre,vida,tamaño);*/
	    }

