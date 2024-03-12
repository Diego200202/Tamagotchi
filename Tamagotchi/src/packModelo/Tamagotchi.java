package packModelo;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import packModelo.evoluciones.Egg;
import packModelo.evoluciones.Evoluciones;
import packModelo.evoluciones.Kuchipatchi;

public class Tamagotchi extends Observable{
    private int vida;
    private int vidaMaxima;
    private int hambre;
    private int hambreMaxima;
    private Evoluciones evo = new Kuchipatchi();
    private boolean estaMuerto = false;
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
                setDatos(estaCagado, estaEnfermo, evo, vida, hambre);
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

    public void setDatos(boolean pCagado, boolean pEnfermo, Evoluciones pEvo, int pVida, int pHambre){
        this.estaCagado = pCagado;
        this.estaEnfermo = pEnfermo;
        this.evo = pEvo;
        this.hambre = pHambre;
        this.vida = pVida;

        this.setChanged();
        this.notifyObservers(new Object[] {pCagado, pEnfermo, evo, vida, hambre});
        
    }
}
