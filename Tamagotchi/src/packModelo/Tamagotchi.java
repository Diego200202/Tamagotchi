package packModelo;

import packModelo.evoluciones.Egg;
import packModelo.evoluciones.Evoluciones;

public class Tamagotchi {
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
