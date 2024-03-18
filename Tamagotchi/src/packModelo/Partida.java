package packModelo;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
//prueba
public class Partida extends Observable{
    private int score;
    private Timer timer = null;
    private Jugador jugador;

    public Partida(Jugador pJugador){
        this.jugador = pJugador;

        TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				score += 1;
                setChanged();
                notifyObservers(new Object[] {score});
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
