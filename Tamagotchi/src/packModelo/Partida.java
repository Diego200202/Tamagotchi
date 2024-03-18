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

    public Partida(Jugador pJugador, Tamagotchi pTamagotchi){
        this.jugador = pJugador;
        this.tamagotchi = pTamagotchi;

        TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				score += 1;
                setChanged();
                notifyObservers(new Object[] {score, tamagotchi.getVida(), tamagotchi.getHambre()});
                terminarPartida();
			}		
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 4000);
    }

    public void terminarPartida(){
        if(this.tamagotchi.estaMuerto()){
            PantallaInicio.getPantallaInicio().setVisible(true);
            this.timer.cancel();
            jugador.setScore(score);
            ListaJugadores.getListaJugadores().addJugador(this.jugador);    
        }
    }
}
