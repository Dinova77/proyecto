package interfaz;

import java.awt.Color;

public abstract class Enemigos {
    protected String nombre; 
    protected int daño;
    protected int tamaño;
    protected int vida;
    protected Color color;
    protected float gravedad;

    public Enemigos(String nombre, int daño, int tamaño, int vida,Color color,float gravedad) {
        this.nombre = nombre;
        this.daño = daño;
        this.tamaño= tamaño;
        this.vida = vida;
        this.color = color;
        this.gravedad = gravedad;

    }

    public String getNombre() {
        return nombre;
    }

    public int getDaño() {
        return daño;
    }

    public int getTamaño() {
        return tamaño;
    }

    public int getvida() {
        return vida;
    }
    public Color getColor() {
        return color;
    }
    public float getgravedad() {
        return (float) gravedad;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void atacar();
}
