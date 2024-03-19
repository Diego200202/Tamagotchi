package packModelo;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import packVista.PantallaInicio;

public class Partida extends Observable{
    private int score;
    private Timer timer = null;
    private Jugador jugador;
    private Tamagotchi tamagotchi;
    private boolean evolucionadoMarutchi = false;

    public Partida(Jugador pJugador, Tamagotchi pTamagotchi){
        this.jugador = pJugador;
        this.tamagotchi = pTamagotchi;
       
        TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				score += 1;
                String evo = tamagotchi.getEvolucion();
                if(evo.equalsIgnoreCase("Marutchi") && !evolucionadoMarutchi){
                    score += 20;
                    evolucionadoMarutchi = true;
                }
                if(tamagotchi.estaCagado()){
                    score -= 5;
                }
                if(tamagotchi.estaEnfermo()){
                    score -= 5;
                }
                setChanged();
                notifyObservers(new Object[] {score, tamagotchi.getVida(), tamagotchi.getHambre(), tamagotchi.getEvolucion(), tamagotchi.estaCagado(), tamagotchi.estaEnfermo()});
                terminarPartida(tamagotchi.estaMuerto());
			}		
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 4000, 4000);
    }

    public void terminarPartida(boolean pMuerto){
        if(pMuerto){
            PantallaInicio.getPantallaInicio().setVisible(true);
            this.timer.cancel();
            jugador.setScore(score);
            ListaJugadores.getListaJugadores().addJugador(this.jugador);    
        }
    }

    public void limpiar(){
        this.tamagotchi.limpiar();
    }

    public void curar(){
        this.tamagotchi.curar();
    }
}
