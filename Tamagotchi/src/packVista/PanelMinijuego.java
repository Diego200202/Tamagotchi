package packVista;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import packModelo.BloqueMinijuego;
import packModelo.Partida;

public class PanelMinijuego extends JLabel implements Observer {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public PanelMinijuego() {
        this.setBackground(Color.BLACK);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        if (arg0 instanceof BloqueMinijuego) {
            if (arg1 instanceof Object[]) {
                Object[] array = (Object[]) arg1;
                if ((int) array[0] == 1) {
                    this.setBackground(Color.decode("#e28743"));
                } else if ((int) array[0] == 2) {
                    this.setBackground(Color.decode("#873e23"));
                } else if ((int) array[0] == 3) {
                    this.setBackground(Color.decode("#2c0500"));
                } else {
                    this.setBackground(Color.BLACK);
                    if ((boolean) array[1]) {
                        this.setIcon(new ImageIcon(this.getClass().getResource(
                                "/imagenes/" + Partida.gePartida().getTamagotchi().getEvolucion() + "1.png")));
                    }

                    if ((boolean) array[2]) {
                        this.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/dorayaki.png")));
                    }
                }
            }
        }
    }
}
