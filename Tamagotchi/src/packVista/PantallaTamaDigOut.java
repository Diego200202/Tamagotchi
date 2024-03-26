package packVista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.BloqueMinijuego;
import packModelo.Partida;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PantallaTamaDigOut extends JFrame {

	private static PantallaTamaDigOut pantalla = null;
	private JPanel contentPane;
	private JPanel panelArriba;
	private JLabel lblEvolucion;
	private JPanel panel;
	private JButton btnExit;
	private JLabel lblScore;
	private JLabel lblPuntos;
	private JPanel panelMedio;
	private JLabel lblTextoAbajo;
	private ArrayList<BloqueMinijuego> listaBloques = new ArrayList<>();
	private ControladorMovimiento controladorMovimiento = null;

	/**
	 * Create the frame.
	 */
	private PantallaTamaDigOut() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelArriba(), BorderLayout.NORTH);
		contentPane.add(getPanelMedio(), BorderLayout.CENTER);
		contentPane.add(getLblTextoAbajo(), BorderLayout.SOUTH);

		addKeyListener(getControladorMovimiento());
		setFocusable(true);

		iniciarTablero();
	}

	public static PantallaTamaDigOut geTamaDigOut() {
		if (pantalla == null) {
			pantalla = new PantallaTamaDigOut();
		}
		return pantalla;
	}

	private JPanel getPanelArriba() {
		if (panelArriba == null) {
			panelArriba = new JPanel();
			panelArriba.setBackground(Color.BLACK);
			panelArriba.setLayout(new GridLayout(1, 3, 0, 0));
			panelArriba.add(getLblEvolucion());
			panelArriba.add(getPanel());
			panelArriba.add(getBtnExit());
		}
		return panelArriba;
	}

	private JLabel getLblEvolucion() {
		if (lblEvolucion == null) {
			lblEvolucion = new JLabel("");
			lblEvolucion.setHorizontalAlignment(SwingConstants.CENTER);
			lblEvolucion.setForeground(Color.WHITE);
			lblEvolucion.setText(Partida.gePartida().getTamagotchi().getEvolucion());
		}
		return lblEvolucion;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			panel.add(getLblScore());
			panel.add(getLblPuntos());
		}
		return panel;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("exit");
			btnExit.setHorizontalAlignment(SwingConstants.TRAILING);
			btnExit.setBackground(Color.BLACK);
			btnExit.setBorder(null);
		}
		return btnExit;
	}

	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("Score: ");
			lblScore.setForeground(Color.WHITE);
			lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblScore;
	}

	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("");
			lblPuntos.setForeground(Color.CYAN);
			lblPuntos.setText(Partida.gePartida().getScore() + "");
		}
		return lblPuntos;
	}

	private JPanel getPanelMedio() {
		if (panelMedio == null) {
			panelMedio = new JPanel();
			panelMedio.setBackground(Color.BLACK);
			panelMedio.setLayout(new GridLayout(8, 12, 2, 2));
		}
		return panelMedio;
	}

	private JLabel getLblTextoAbajo() {
		if (lblTextoAbajo == null) {
			lblTextoAbajo = new JLabel("ooh.. Still Far Away!");
			lblTextoAbajo.setForeground(Color.WHITE);
			lblTextoAbajo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTextoAbajo;
	}

	private void iniciarTablero() {
		Random random = new Random();
		int posTamagotchi = random.nextInt(96);
		int posPastel = random.nextInt(96);
		do {
			posPastel = random.nextInt(96);
		} while (posPastel == posTamagotchi);

		for (int i = 0; i < 96; i++) {
			int dureza = random.nextInt(3) + 1;
			BloqueMinijuego bloque = new BloqueMinijuego(i, dureza);
			PanelMinijuego label = new PanelMinijuego(i);
			label.setOpaque(true);
			if (i == posTamagotchi) {
				bloque.setTamagotchi(true);
			} else if (i == posPastel) {
				bloque.setPastel();
			}
			bloque.addObserver((Observer) label);
			bloque.setDatos();
			this.listaBloques.add(bloque);
			getPanelMedio().add(label);
		}
	}

	public ArrayList<BloqueMinijuego> getListaBloques() {
		return this.listaBloques;
	}

	private int getPosBloqueTamagotchi() {
		int pos = -1;
		for (BloqueMinijuego b : getListaBloques()) {
			if (b.getTamagotchi()) {
				pos = b.getPos();
			}
		}
		return pos;
	}
	public void reset(){
		pantalla = null;
	}

	private ControladorMovimiento getControladorMovimiento() {
		if (controladorMovimiento == null) {
			controladorMovimiento = new ControladorMovimiento();
		}
		return controladorMovimiento;
	}

	private class ControladorMovimiento implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if (Character.toString(arg0.getKeyChar()).equalsIgnoreCase("a")) {
				int num = getPosBloqueTamagotchi();
				if (num % 12 != 0 && getListaBloques().get(num - 1).getDureza() == 0) {
					getListaBloques().get(num - 1).setTamagotchi(true);
					getListaBloques().get(num).setTamagotchi(false);

					getListaBloques().get(num - 1).setDatos();
					getListaBloques().get(num).setDatos();
				}
			}

			else if (Character.toString(arg0.getKeyChar()).equalsIgnoreCase("w")) {
				int num = getPosBloqueTamagotchi();
				if (num > 12 && getListaBloques().get(num - 12).getDureza() == 0) {
					getListaBloques().get(num - 12).setTamagotchi(true);
					getListaBloques().get(num).setTamagotchi(false);

					getListaBloques().get(num - 12).setDatos();
					getListaBloques().get(num).setDatos();
				}
			}

			else if (Character.toString(arg0.getKeyChar()).equalsIgnoreCase("d")) {
				int num = getPosBloqueTamagotchi();
				if (num % 12 != 11 && getListaBloques().get(num + 1).getDureza() == 0) {
					getListaBloques().get(num + 1).setTamagotchi(true);
					getListaBloques().get(num).setTamagotchi(false);

					getListaBloques().get(num + 1).setDatos();
					getListaBloques().get(num).setDatos();
				}
			}

			else if (Character.toString(arg0.getKeyChar()).equalsIgnoreCase("s")) {
				int num = getPosBloqueTamagotchi();
				if (num + 12 < 96 && getListaBloques().get(num + 12).getDureza() == 0) {
					getListaBloques().get(num + 12).setTamagotchi(true);
					getListaBloques().get(num).setTamagotchi(false);

					getListaBloques().get(num + 12).setDatos();
					getListaBloques().get(num).setDatos();
				}
			}

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}