package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.BloqueMinijuego;
import packModelo.CrearBloques;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PantallaTamaDigOut extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelArriba;
	private JLabel lblEvolucion;
	private JPanel panel;
	private JButton btnExit;
	private JLabel lblScore;
	private JLabel lblPuntos;
	private JPanel panelMedio;
	private JLabel lblTextoAbajo;
	private BloqueMinijuego[][] tablero = new BloqueMinijuego[8][12];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaTamaDigOut frame = new PantallaTamaDigOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaTamaDigOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelArriba(), BorderLayout.NORTH);
		contentPane.add(getPanelMedio(), BorderLayout.CENTER);
		contentPane.add(getLblTextoAbajo(), BorderLayout.SOUTH);
		
		llenarTablero();
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
	
	public BloqueMinijuego crearLabeles(int pDureza) {
		return new BloqueMinijuego("", pDureza);
	}
	
	public void llenarTablero() {
		Random random = new Random();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 12; j++) {
				int dur = random.nextInt(3)+1;
				tablero[i][j] = CrearBloques.getFactory().crearLabel(dur);
				getPanelMedio().add(tablero[i][j]);
			}
		}
	}
}