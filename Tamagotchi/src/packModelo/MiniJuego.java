package packModelo;

import java.util.Observable;
import java.util.Observer;

public class MiniJuego extends Observable{
    private static MiniJuego miniJuego = null;
    private int score;
    private String evolucion;

    private MiniJuego(){

    }

    public static MiniJuego getMiniJuego(){
        if (miniJuego == null) {
            miniJuego = new MiniJuego();
        }
        return miniJuego;
    }

}
