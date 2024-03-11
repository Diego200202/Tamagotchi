package packModelo.evoluciones;

public class Kuchipatchi implements Evoluciones{
    private int corazones = 2;
    private int comida = 5;
    
    public Kuchipatchi(){

    }

    public int decrementoCorazones(){
        return this.corazones;
    }

    public int decrementoComida(){
        return this.comida;
    }
}
