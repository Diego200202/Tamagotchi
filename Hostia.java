import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;

public class Hostia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelArriba;
	private JPanel panelAbajo;
	private JPanel panelMedio;
	private JLabel lblEvo;
	private JLabel lblScore;
	private JButton btnNewButton;
	private JLabel lblAbajo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hostia frame = new Hostia();
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
	public Hostia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelArriba(), BorderLayout.NORTH);
		contentPane.add(getPanelMedio(), BorderLayout.CENTER);
		contentPane.add(getPanelAbajo(), BorderLayout.SOUTH);
		
		crearButtons();
	}

	private JPanel getPanelArriba() {
		if (panelArriba == null) {
			panelArriba = new JPanel();
			panelArriba.setBackground(new Color(0, 0, 0));
			panelArriba.setLayout(new GridLayout(0, 3, 0, 0));
			panelArriba.add(getLblEvo());
			panelArriba.add(getLblScore());
			panelArriba.add(getBtnNewButton());
		}
		return panelArriba;
	}
	private JPanel getPanelAbajo() {
		if (panelAbajo == null) {
			panelAbajo = new JPanel();
			panelAbajo.setBackground(new Color(0, 0, 0));
			panelAbajo.add(getLblAbajo());
		}
		return panelAbajo;
	}
	private JPanel getPanelMedio() {
		if (panelMedio == null) {
			panelMedio = new JPanel();
			panelMedio.setBackground(new Color(0, 0, 0));
			panelMedio.setLayout(new GridLayout(8, 12, 0, 0));
		}
		return panelMedio;
	}
	private JLabel getLblEvo() {
		if (lblEvo == null) {
			lblEvo = new JLabel("Evo");
			lblEvo.setForeground(new Color(255, 255, 255));
		}
		return lblEvo;
	}
	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("Score");
			lblScore.setForeground(new Color(53, 132, 228));
		}
		return lblScore;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setBackground(new Color(0, 0, 0));
		}
		return btnNewButton;
	}
	private JLabel getLblAbajo() {
		if (lblAbajo == null) {
			lblAbajo = new JLabel("oh, no so far from santurtzi");
			lblAbajo.setForeground(new Color(255, 255, 255));
		}
		return lblAbajo;
	}
	private void crearButtons() {
		int i,j;
		
		for(i=0; i<96;i++) {
			panelMedio.add(cbt(""), BorderLayout.CENTER);
		}
	}
	private JLabel cbt(String pType) {
		JLabel labelNew = new JLabel(pType);
		labelNew.setBorder(BorderFactory.createLineBorder(Color.black));
		labelNew.setOpaque(true);
		labelNew.setBackground(Color.red);
		return labelNew;
	}
}
