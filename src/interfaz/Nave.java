package interfaz;

import java.util.Random;

public class Nave {
	    final int velocidadmaxima=5000;
	    String nombre;
	    String nombrePiloto;
	    int distanciaNaveenemigo;
	    double distanciaNaveObjeto;
	    int velocidadNave;
	    int cantidadBalas;
	    int cantidadCapsulas;
	    int cantidadObjetosInteres;
	    int cantidaddeenemigosdestruidos;

	    public Nave(String nombre, String nombrepiloto,int cantidadBalas,int cantidadCapsulas,int cantidadObjetosinteres) {
	        this.nombre = nombre;
	        this.nombrePiloto = nombrepiloto;
	        this.cantidadCapsulas = 2000;
	        this.cantidadBalas = 10000;
	        this.cantidadObjetosInteres = 0;
	        this.cantidaddeenemigosdestruidos = 0;

	        actualizarValoresAleatorios();
	    }
	    
	    public void actualizarValoresAleatorios() {
	        Random rand = new Random();
	        this.distanciaNaveenemigo = rand.nextInt(501) + 100;
	        Random rand1 = new Random();
	        this.distanciaNaveObjeto = 2 + (double) (Math.random() * 0.5);
	        this.distanciaNaveObjeto = Math.round(this.distanciaNaveObjeto * 10) / 10.0; // Redondear a un decimal
	        Random rand2 = new Random();
	        this.velocidadNave = rand2.nextInt(4500) + 500;
	       
	        
	        }
	    
	    public  String getnombre() {
	        return nombre;
	    }

	    public  String getnombrepiloto () {
	        return nombrePiloto;
	    }
 
	    public int getdistanciaNaveenemigo() {
	        return distanciaNaveenemigo;
	    }

	    public  double getdistanciaNaveObjeto() {
	        return distanciaNaveObjeto;
	    }
	    public int getvelocidadNave() {
	        return velocidadNave;
	    }

	    public  int getcantidadBalas() {
	        return  cantidadBalas;
	    }

	    public int getcantidadCapsulas() {
	        return cantidadCapsulas;
	    }

	    public int getcantidadObjetosInteres() {
	        return cantidadObjetosInteres;
	    }
	    public int getcantidaddeenemigosdestruidos() {
	    	return cantidaddeenemigosdestruidos;
	    }


	    public void imprimirValores() {
	        System.out.println("Nombre: " + this.nombre);
	        System.out.println("Nombre del Piloto: " + this.nombrePiloto);
	        System.out.println("Distancia a Nave enemiga: " + this.distanciaNaveenemigo);
	        System.out.println("Distancia a Objeto: " + this.distanciaNaveObjeto);
	        System.out.println("Velocidad: " + this.velocidadNave);
	        System.out.println("Cantidad de Balas: " + this.cantidadBalas);
	        System.out.println("Cantidad de Capsulas: " + this.cantidadCapsulas);
	        System.out.println("Cantidad de Objetos de Interes: " + this.cantidadObjetosInteres);
	    }
	    public void setCantidadCapsulas(int cantidadCapsulas) {
	        this.cantidadCapsulas = cantidadCapsulas;
	    }
		public void setcantidadObjetosInteres( int cantidadObjetosInteres) {
			this.cantidadObjetosInteres = cantidadObjetosInteres;
			
		}

		public void setCantidadBalas(int cantidadBalas) {
			this.cantidadBalas = cantidadBalas;
			
		}
		  public void setnombrePiloto(String nombrePiloto) {
		        this.nombrePiloto = nombrePiloto;
		    }	
		  public void setcantidaddeenemigosdestruidos(int cantidaddeenemigosdestruidos) {
			  this.cantidaddeenemigosdestruidos = cantidaddeenemigosdestruidos;
		  }


		
}

		
		
			
			


