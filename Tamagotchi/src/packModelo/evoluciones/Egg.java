package packModelo.evoluciones;

public class Egg implements Evoluciones{

    private int corazones = 0;
    private int comida = 0;
    
    public Egg(){

    }

    public int decrementoCorazones(){
        return this.corazones;
    }

    public int decrementoComida(){
        return this.comida;
    }
}
