package interfaz;

import java.awt.Color;

public class Metioritos extends Enemigos{
    public Metioritos(String nombre, int daño, int tamaño, int vida,float gravedad) {
        super(nombre, daño, tamaño, vida,Color.GRAY,gravedad);
    }

    @Override
    public void atacar() {
        System.out.println("Metiorito atacando...");
    }
}
