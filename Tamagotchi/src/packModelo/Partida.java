package packModelo;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import packVista.PantallaInicio;

public class Partida extends Observable {
    public static Partida partida = null;
    private int score;
    private Timer timer = null;
    private Jugador jugador;
    private Tamagotchi tamagotchi;
    private boolean evolucionadoMarutchi = false;
    private int elementos;
    private int piruletas;
    private int sopas;

    private Partida() {
        this.elementos = 0;
        this.piruletas = 0;
        this.sopas = 0;

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // Actualizar la puntuación y bajar la vida de la comida cada 4 segundos
                score += 1;
                String evo = tamagotchi.getEvolucion();
                if (evo.equalsIgnoreCase("Marutchi") && !evolucionadoMarutchi) {
                    score += 20;
                    evolucionadoMarutchi = true;
                }
                if (tamagotchi.estaCagado()) {
                    score -= 5;
                }
                if (tamagotchi.estaEnfermo()) {
                    score -= 5;
                }
                tamagotchi.bajarVidaComida();
                tamagotchi.cagarse();
                tamagotchi.ponerEnfermo();
                alimentar();
                // Notificar cambios de puntuación y hambre a los observadores
                setChanged();
                notifyObservers(new Object[] { score, tamagotchi.getVida(), tamagotchi.getHambre(),
                        tamagotchi.getEvolucion() });
            }
        };

        TimerTask timerTaskEstado = new TimerTask() {
            @Override
            public void run() {
                // Actualizar el estado del Tamagotchi cada 2 segundos

                boolean cagado = tamagotchi.estaCagado();
                boolean enfermo = tamagotchi.estaEnfermo();
                boolean quiereJugar = tamagotchi.quiereJugar();
                // Notificar cambios de estado a los observadores
                setChanged();
                notifyObservers(new boolean[] { cagado, enfermo, quiereJugar });
            }
        };

        TimerTask timerTernimarPartida = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                terminarPartida(tamagotchi.estaMuerto());
                setChanged();
                notifyObservers(new int[] { getPiruletas(), getSopas() });
            }

        };

        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 4000, 4000); // Actualizar cada 4 segundos
        timer.scheduleAtFixedRate(timerTaskEstado, 1000, 2000); // Actualizar cada 2 segundos
        timer.scheduleAtFixedRate(timerTernimarPartida, 1000, 1000); // Actualizar cada 1 segundo
    }

    public static Partida gePartida() {
        if (partida == null) {
            partida = new Partida();
        }
        return partida;
    }

    public void terminarPartida(boolean pMuerto) {
        if (pMuerto) {
            PantallaInicio.getPantallaInicio().setVisible(true);
            this.timer.cancel();
            jugador.setScore(score);
            ListaJugadores.getListaJugadores().addJugador(this.jugador);
        }
    }

    public void limpiar() {
        this.tamagotchi.limpiar();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tamagotchi.puedeCagar(true);
            }
        }, 5000); // 5000 milisegundos = 5 segundos
    }

    public void curar() {
        this.tamagotchi.curar();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tamagotchi.puedeEnfermar(true);
            }
        }, 5000); // 5000 milisegundos = 5 segundos
    }

    public void setJugador(Jugador pJugador) {
        this.jugador = pJugador;
    }

    public void setTamagotchi(Tamagotchi pTamagotchi) {
        this.tamagotchi = pTamagotchi;
    }

    public void alimentar() {
        while (this.piruletas > 0) {
            this.tamagotchi.comerPiruleta();
            if (this.tamagotchi.getVida() > 40) {
                this.tamagotchi.setVida(40);
                score -= 5;
            }
            this.piruletas--;
        }

        while (this.sopas > 0) {
            this.tamagotchi.comerSopa();
            if (this.tamagotchi.getHambre() > 40) {
                this.tamagotchi.setHambre(40);
                score -= 5;
            }
            this.sopas--;
        }
        score += elementos * 3 * elementos;
        this.vaciarElementos();
    }

    public void addPiruleta() {
        if (this.piruletas < 3 && sePuedeAñadirElem()) {
            this.piruletas += 1;
            this.elementos += 1;
        }
    }

    public void addSopa() {
        if (this.sopas < 3 && sePuedeAñadirElem()) {
            this.sopas += 1;
            elementos += 1;
        }
    }

    public boolean sePuedeAñadirElem() {
        if (this.elementos <= 6) {
            return true;
        } else {
            return false;
        }
    }

    public void vaciarElementos() {
        this.piruletas = 0;
        this.sopas = 0;
        this.elementos = 0;
    }

    public int getPiruletas() {
        return this.piruletas;
    }

    public int getSopas() {
        return this.sopas;
    }
}
