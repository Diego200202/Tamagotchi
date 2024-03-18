package packModelo;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import packModelo.evoluciones.Egg;
import packModelo.evoluciones.Evoluciones;
import packModelo.evoluciones.Kuchipatchi;
import packModelo.evoluciones.Maskutchi;

public class Tamagotchi{
    private int vida;
    private int vidaMaxima;
    private int hambre;
    private int hambreMaxima;
    private Evoluciones evo = new Kuchipatchi();
    private boolean estaCagado = false;
    private boolean estaEnfermo = false;
    private Random random = new Random();
    private Timer timer;

    public Tamagotchi(){
        this.vida = 40;
        this.vidaMaxima = 40;
        this.hambre = 40;
        this.hambreMaxima = 40;  

        TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				bajarVidaComida();
                cagarse();
                ponerEnfermo();
			}		
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 4000);
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

    public void bajarVidaComida(){
        this.vida -= evo.decrementoCorazones();
        this.hambre -= evo.decrementoComida();
    }

    public int getVida(){
        return this.vida;
    }

    public int getHambre(){
        return this.hambre;
    }

    public void evolucionar(){

    }

    public boolean estaMuerto(){
        if (this.vida <= 0 || this.hambre <= 0) {
            return true;
        }
        return false;
    }
}
