package interfaz;
import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
public class main {
	 static boolean seguirJugando = true;
public static void main(String[] args) {
	    int cantidadBalas = 10000;
        int cantidadCapsulas = 2000;
        int cantidadObjetosinteres = 0;
        ventana Ventana = new ventana(); 
        Ventana.setVisible(true); // Mostrar la ventana
        
     

	    Scanner sc = new Scanner(System.in);
	    // Preguntar al usuario por el nombre del piloto
        System.out.print("\033[31mIngrese el nombre del piloto:\033[0m");
        String nombrepiloto = sc.nextLine();
        Nave nave = new Nave("comando z ", nombrepiloto, cantidadBalas, cantidadCapsulas, cantidadObjetosinteres);
        // asigna valores a los atributos de nave y logica
        String nombrePiloto = nave.getnombrepiloto();
        nave.imprimirValores();
}}



    

                
                    
                