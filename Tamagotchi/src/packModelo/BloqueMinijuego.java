package packModelo;

import javax.swing.JLabel;

public class BloqueMinijuego extends JLabel{
    int dureza;

    public BloqueMinijuego(String pTexto, int pDureza){
        super(pTexto);
        this.dureza = pDureza;
    }

    public int getDureza(){
        return this.dureza;
    }
}
