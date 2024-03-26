package packModelo;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import packVista.PantallaInicio;
import packVista.PantallaPrincipal;
import packVista.PantallaTamaDigOut;

public class Juego extends Observable{
    private static Juego juego = null;
    private Timer timerTerminar = null;
    private int cont = 20;

    private Juego(){

    }

    public static Juego getJuego(){
        if(juego == null){
            juego = new Juego();
        }
        return juego;
    }

    public void iniciarPartida(String pNombre){
        Jugador jugador = new Jugador(pNombre, 0);
        Tamagotchi tamagotchi = new Tamagotchi();
        Partida.gePartida().setJugador(jugador);
        Partida.gePartida().setTamagotchi(tamagotchi);
        setChanged();
        notifyObservers();
    }

    public void iniciarMinijuego(){
        Partida.gePartida().pararTimer();
        timerTerminar = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                finalMinijuego(terminarMinijuego());
                if (cont == 0) {
                    finalMinijuego(true);
                    Partida.gePartida().setScore(-20);
                }
            }
            
        };

        timerTerminar.scheduleAtFixedRate(timerTask, 0000, 1000);
    }

    private boolean terminarMinijuego(){
        boolean terminar = false;
        for(BloqueMinijuego b : PantallaTamaDigOut.geTamaDigOut().getListaBloques()){
            if (!terminar) {
                if (b.getTamagotchi() && b.getPastel()) {
                    terminar =  true;
                }
            }
        }
        return terminar;
    }

    private void finalMinijuego(boolean pBoolean){
        if (pBoolean) {
            timerTerminar.cancel();
            timerTerminar.purge();
            timerTerminar = null;
            PantallaTamaDigOut.geTamaDigOut().setVisible(false);
            PantallaPrincipal.getPantalla().setVisible(true);
            Partida.gePartida().setScore(20);
            Partida.gePartida().iniciarTimer();
            Partida.gePartida().getTamagotchi().puedeJugar(true);
            PantallaTamaDigOut.geTamaDigOut().reset();
        }
    }
}
