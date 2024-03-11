package packModelo;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import packModelo.evoluciones.Egg;
import packModelo.evoluciones.Evoluciones;

public class Tamagotchi extends Observable{
    private int vida;
    private int vidaMaxima;
    private int hambre;
    private int hambreMaxima;
    private Evoluciones evo = new Egg();
    private boolean estaMuerto = false;
    private boolean estaCagado = false;
    private boolean estaEnfermo = false;
    private Random random = new Random();

    public Tamagotchi(){
        this.vida = 40;
        this.vidaMaxima = 40;
        this.hambre = 40;
        this.hambreMaxima = 40;  
    }

    public void ponerEnfermo(){
        int num = random.nextInt(101);
        if(num <= 30){
            this.estaEnfermo = true;
        }
    }

    public void cagarse(){
        int num = random.nextInt(101);
        if(num <= 20){
            this.estaCagado = true;
        }
    }

    public void limpiar(){
        this.estaCagado = false;
    }

    public void curar(){
        this.estaEnfermo = false;
    }
}
