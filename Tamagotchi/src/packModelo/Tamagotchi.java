package packModelo;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import packModelo.evoluciones.Egg;
import packModelo.evoluciones.Evoluciones;
import packModelo.evoluciones.Kuchipatchi;
import packModelo.evoluciones.Marutchi;
import packModelo.evoluciones.Maskutchi;
import packModelo.evoluciones.Mimitchi;

public class Tamagotchi{
    private int vida;
    private int vidaMaxima;
    private int hambre;
    private int hambreMaxima;
    private Evoluciones evo = new Egg();
    private boolean estaCagado = false;
    private boolean estaEnfermo = false;
    private Random random = new Random();
    private Timer timer4seg;
    private Timer timerEvolucionar;

    public Tamagotchi(){
        this.vida = 40;
        this.vidaMaxima = 40;
        this.hambre = 40;
        this.hambreMaxima = 40;  

        TimerTask timerTask4seg = new TimerTask() {
			@Override
			public void run() {
				bajarVidaComida();
                cagarse();
                ponerEnfermo();
			}		
		};
		timer4seg = new Timer();
		timer4seg.scheduleAtFixedRate(timerTask4seg, 4000,4000);

        TimerTask timerTask15seg = new TimerTask() {
			@Override
			public void run() {
				evolucionar();
			}		
		};
		timerEvolucionar = new Timer();
		timerEvolucionar.scheduleAtFixedRate(timerTask15seg, 8000, 8000);
    }

    public void ponerEnfermo(){
        if(!estaEnfermo){
            int num = random.nextInt(100);
            if(num <= 29){
                this.estaCagado = true;
            }
        }
    }

    public void cagarse(){
        if(!estaCagado){
            int num = random.nextInt(100);
            if(num <= 19){
                this.estaCagado = true;
            }
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
        boolean evolucionado = false;
        while(!evolucionado){
            if(this.evo.evolucion().equalsIgnoreCase("Egg")){
                this.evo = new Kuchipatchi();
                evolucionado = true;
            }else if (this.getEvolucion().equalsIgnoreCase("Kuchipatchi")) {
                this.evo = new Mimitchi();
                evolucionado = true;
            }else if (this.getEvolucion().equalsIgnoreCase("Mimitchi")) {
                if(this.getVida() >= 30 || this.getHambre() >= 30){
                    this.evo = new Marutchi();
                    evolucionado = true;
                }else{
                    this.evo = new Maskutchi();
                    evolucionado = true;
                }
            }           
        }
    }

    public boolean estaMuerto(){
        if (this.vida <= 0 || this.hambre <= 0) {
            return true;
        }
        return false;
    }

    public String getEvolucion(){
        return this.evo.evolucion();
    }
}
