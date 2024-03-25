package packModelo;

import java.awt.Color;

public class CrearBloques {
	private static CrearBloques factoria = null;
	
    private CrearBloques(){

    }

	public static CrearBloques getFactory() {
		if(factoria == null) {
			factoria = new CrearBloques();
		}
		return factoria;
	}
	
	public BloqueMinijuego crearLabel(int pDureza) {
		BloqueMinijuego lbl = new BloqueMinijuego("", pDureza);
		switch(pDureza) {
		case 1:
			lbl.setBackground(Color.decode("#e28743"));
			break;
		case 2:
			lbl.setBackground(Color.decode("#873e23"));
			break;
		case 3:
			lbl.setBackground(Color.decode("#2c0500"));
		}
		lbl.setOpaque(true);
		return lbl;
	}
}