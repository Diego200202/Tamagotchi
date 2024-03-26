package packVista;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import packModelo.BloqueMinijuego;
import packModelo.Partida;

public class PanelMinijuego extends JLabel implements Observer {

    private static final long serialVersionUID = 1L;
    private int pos;
    private ControladorPaneles controlador = null;

    /**
     * Create the panel.
     */
    public PanelMinijuego(int pPos) {
        this.pos = pPos;

        this.setBackground(Color.BLACK);
        this.addMouseListener(getControlador());
    }

    private int getPos() {
        return this.pos;
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
                                "/imagenes/MarutchiMini1.png")));
                    }

                    if ((boolean) array[2]) {
                        this.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/dorayakiSmall.png")));
                    }
                }
            }
        }
    }

    private ControladorPaneles getControlador(){
        if(controlador == null){
            controlador = new ControladorPaneles();
        }
        return controlador;
    }

    private class ControladorPaneles implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub
            PantallaTamaDigOut.geTamaDigOut().getListaBloques().get(getPos()).quitarDureza();
            PantallaTamaDigOut.geTamaDigOut().getListaBloques().get(getPos()).setDatos();
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

    }
}
