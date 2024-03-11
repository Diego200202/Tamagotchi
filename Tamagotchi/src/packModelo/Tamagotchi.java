package packModelo;

import java.util.Observable;
import java.util.Observer;

import packModelo.evoluciones.Egg;
import packModelo.evoluciones.Evoluciones;

public class Tamagotchi extends Observable{
    private int vida;
    private int vidaMaxima;
    private int hambre;
    private int hambreMaxima;
    private Evoluciones evo = new Egg();

    public Tamagotchi(){
        this.vida = 40;
        this.vidaMaxima = 40;
        this.hambre = 40;
        this.hambreMaxima = 40;  
    }
}
