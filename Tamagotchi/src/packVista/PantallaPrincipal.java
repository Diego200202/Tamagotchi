package packVista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDatos;
	private JLabel lblEvolucion;
	private JLabel lblScore;
	private JPanel panel;
	private JLabel lblPuntos;
	private JButton btnExit;

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		setTitle("Tamagotchi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelDatos(), BorderLayout.NORTH);
	}

	private JPanel getPanelDatos() {
		if (panelDatos == null) {
			panelDatos = new JPanel();
			panelDatos.setBackground(Color.BLACK);
			panelDatos.setLayout(new GridLayout(0, 3, 0, 0));
			panelDatos.add(getLblEvolucion());
			panelDatos.add(getPanel());
			panelDatos.add(getBtnExit());
		}
		return panelDatos;
	}
	private JLabel getLblEvolucion() {
		if (lblEvolucion == null) {
			lblEvolucion = new JLabel("Evolucion");
			lblEvolucion.setForeground(Color.WHITE);
			lblEvolucion.setBackground(Color.BLACK);
		}
		return lblEvolucion;
	}
	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("Score: ");
			lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore.setForeground(Color.WHITE);
		}
		return lblScore;
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
	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("5");
			lblPuntos.setForeground(Color.CYAN);
		}
		return lblPuntos;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("exit");
			btnExit.setHorizontalAlignment(SwingConstants.TRAILING);
			btnExit.setBackground(Color.BLACK);
			btnExit.setForeground(Color.GRAY);
			btnExit.setBorder(null);
			btnExit.setBorderPainted(false);
		}
		return btnExit;
	}
}