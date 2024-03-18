package packModelo;

import packVista.PantallaInicio;
import packVista.PantallaPrincipal;

public class Juego {
    private static Juego juego = null;

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
        Partida partida = new Partida(jugador, tamagotchi);
        PantallaPrincipal pantalla = new PantallaPrincipal(partida);
        pantalla.setVisible(true);
        PantallaInicio.getPantallaInicio().setVisible(false);
    }
}
