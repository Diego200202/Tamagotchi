package packModelo;

import java.util.Observable;

public class BloqueMinijuego extends Observable{
    private int dureza;
    private boolean tieneTamagotchi = false;
    private boolean tienePastel = false;

    public BloqueMinijuego(int pDureza){
        this.dureza = pDureza; 

    }

    public int getDureza(){
        return this.dureza;
    }

    public boolean getTamagotchi(){
        return this.tieneTamagotchi;
    }

    public void setTamagotchi(){
        this.tieneTamagotchi = true;
    }

    public boolean getPastel(){
        return this.tienePastel;
    }

    public void setPastel(){
        this.tienePastel = true;
    }


    public void quitarDureza(){
        if(this.dureza > 0){
            this.dureza--;
        }
        this.setDatos();
    }

    public void setDatos(){
        setChanged();
        notifyObservers(new Object[]{this.getDureza(), this.getTamagotchi(), this.getPastel()});
    }
}
