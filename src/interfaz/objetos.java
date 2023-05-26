package interfaz;

import java.awt.Color;

public abstract class objetos {
    public int vida;
    public String nombre;
    public double tamaño;
    public int capsulas;
    public int balas;
    public Color color;
    

    public objetos(int vida, String nombre,double tamaño,int balas,int capsulas,Color color) {
        this.vida = vida;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.balas = balas;
        this.capsulas = capsulas;
    }

    // Métodos getters y setters para vida y nombre
    public String getNombre() {
        return nombre;
    }

    public int getvida() {
        return vida;
    }
    public float gettamaño() {
        return (float) tamaño;
    }
    public int getbalas() {
	return balas;
    }
	public int getcapsulas(){
		return capsulas;
	}
	 public Color getColor() {
	        return color;
	    }
}



class ObjetoClase1 extends objetos {
    public ObjetoClase1(String nombre, int vida,double tamaño,int balas,int capsulas) {
        super(vida,nombre,tamaño,balas,capsulas,Color.RED);
    }
}


class ObjetoClase2 extends objetos {
	    public ObjetoClase2(String nombre, int vida,double tamaño,int balas,int capsulas) {
	        super(vida, nombre,tamaño,balas,capsulas,Color.RED);
	    }
	}
class ObjetoClase3 extends objetos {
    public ObjetoClase3(String nombre, int vida,double tamaño,int balas,int capsulas) {
        super(vida, nombre,tamaño,balas,capsulas,Color.RED);
    }
}


