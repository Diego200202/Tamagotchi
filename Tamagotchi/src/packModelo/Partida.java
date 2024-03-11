package packModelo;

import java.util.Timer;
import java.util.TimerTask;

public class Partida {
    private int score;
    private Timer timer = null;
    private Jugador jugador;

    public Partida(Jugador pJugador){
        this.jugador = pJugador;

        TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				score += 1;
			}		
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 4000);
    }

    public void terminarPartida(){
        this.timer.cancel();
        jugador.setScore(score);
        ListaJugadores.getListaJugadores().addJugador(this.jugador);
    }
}
