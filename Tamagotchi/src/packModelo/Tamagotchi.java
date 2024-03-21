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

public class Tamagotchi {
    private int vida;
    private int hambre;
    private Evoluciones evo = new Egg();
    private boolean estaCagado = false;
    private boolean estaEnfermo = false;
    private Random random = new Random();
    private Timer timerEvolucionar;
    private boolean puedeCagar = true;
    private boolean puedeEnfermar = true;

    public Tamagotchi() {
        this.vida = 40;
        this.hambre = 40;

        TimerTask timerTask15seg = new TimerTask() {
            @Override
            public void run() {
                evolucionar();
            }
        };
        timerEvolucionar = new Timer();
        timerEvolucionar.scheduleAtFixedRate(timerTask15seg, 8000, 8000);
    }

    public void ponerEnfermo() {
        if (!estaEnfermo && !estaCagado && puedeEnfermar) {
            int num = random.nextInt(100);
            if (num <= 29) {
                this.estaEnfermo = true;
                puedeEnfermar(false);
            }
        }
    }

    public void cagarse() {
        if (!estaCagado && !estaEnfermo && puedeCagar) {
            int num = random.nextInt(100);
            if (num <= 19) {
                this.estaCagado = true;
                puedeCagar(false);
            }
        }
    }

    public void limpiar() {
        this.estaCagado = false;
    }

    public void curar() {
        this.estaEnfermo = false;
    }

    public void bajarVidaComida() {
        int i = 0;
        int j = 0;
        if (estaCagado) {
            i = 5;
            j = 10;
        }
        if (estaEnfermo) {
            i = 7;
            j = 5;
        }
        this.vida = this.vida - this.evo.decrementoCorazones() - i;
        this.hambre = this.hambre - evo.decrementoComida() + j;
    }

    public int getVida() {
        return this.vida;
    }

    public int getHambre() {
        return this.hambre;
    }

    public void evolucionar() {
        boolean evolucionado = false;
        while (!evolucionado) {
            if (this.evo.evolucion().equalsIgnoreCase("Egg")) {
                this.evo = new Kuchipatchi();
                evolucionado = true;
            } else if (this.getEvolucion().equalsIgnoreCase("Kuchipatchi")) {
                this.evo = new Mimitchi();
                evolucionado = true;
            } else if (this.getEvolucion().equalsIgnoreCase("Mimitchi")) {
                if (this.getVida() >= 30 && this.getHambre() >= 30) {
                    this.evo = new Marutchi();
                    evolucionado = true;
                } else {
                    this.evo = new Maskutchi();
                    evolucionado = true;
                }
            }
        }
    }

    public boolean estaMuerto() {
        if (this.vida <= 0 || this.hambre <= 0) {
            return true;
        }
        return false;
    }

    public String getEvolucion() {
        return this.evo.evolucion();
    }

    public boolean estaCagado() {
        return this.estaCagado;
    }

    public boolean estaEnfermo() {
        return this.estaEnfermo;
    }

    public void puedeCagar(boolean pBoolean) {
        this.puedeCagar = pBoolean;
    }

    public void puedeEnfermar(boolean pBoolean) {
        this.puedeEnfermar = pBoolean;
    }

    public void comerPiruleta() {
        this.vida += 10;
    }

    public void comerSopa() {
        this.hambre += 10;
    }

    public void setVida(int pVida){
        this.vida = pVida;
    }

    public void setHambre(int pHambre){
        this.hambre = pHambre;
    }
}
