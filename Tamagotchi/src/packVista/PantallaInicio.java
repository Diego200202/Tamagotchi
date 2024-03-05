package packVista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelNorte;
	private JLabel lblImagen;
	private JPanel panelMedio;
	private JPanel panelMedioArriba;
	private JPanel panelMedioAbajo;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JButton btnPlay;
	private JButton btnExit;
	private JLabel lblLeaderBoard;
	private JLabel lblVacio;
	private JPanel panelAbajo;
	private JPanel panelAbajoIzda;
	private JPanel panelTitulos;
	private JPanel panelRecords;
	private JLabel lblRank;
	private JLabel lblName;
	private JLabel lblScore;
	private JPanel panelAbajoDer;
	private JLabel lblImagenAbajo;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio frame = new PantallaInicio();
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
	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.setBackground(Color.BLACK);
		contentPane.add(getPanelMedio(), BorderLayout.CENTER);
		contentPane.add(getPanelAbajo(), BorderLayout.SOUTH);

		this.crearRecords();
	}

	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setBackground(Color.BLACK);
			panelNorte.add(getLblImagen());
		}
		return panelNorte;
	}

	private JLabel getLblImagen() {
		if (lblImagen == null) {
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/logo.png"));
			lblImagen = new JLabel(img);
		}
		return lblImagen;
	}

	private JPanel getPanelMedio() {
		if (panelMedio == null) {
			panelMedio = new JPanel();
			panelMedio.setBackground(Color.BLACK);
			panelMedio.setLayout(new GridLayout(2, 1, 0, 0));
			panelMedio.add(getPanelMedioArriba());
			panelMedio.add(getPanelMedioAbajo());
		}
		return panelMedio;
	}

	private JPanel getPanelMedioArriba() {
		if (panelMedioArriba == null) {
			panelMedioArriba = new JPanel();
			panelMedioArriba.setBackground(Color.BLACK);
			panelMedioArriba.setLayout(new GridLayout(0, 4, 6, 0));
			panelMedioArriba.add(getLblNombre());
			panelMedioArriba.add(getTextFieldNombre());
			panelMedioArriba.add(getBtnPlay());
			panelMedioArriba.add(getBtnExit());
		}
		return panelMedioArriba;
	}

	private JPanel getPanelMedioAbajo() {
		if (panelMedioAbajo == null) {
			panelMedioAbajo = new JPanel();
			panelMedioAbajo.setBackground(Color.BLACK);
			panelMedioAbajo.setLayout(new GridLayout(0, 2, 0, 0));
			panelMedioAbajo.add(getPanel());
			panelMedioAbajo.add(getLblVacio());
		}
		return panelMedioAbajo;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Your Name:");
			lblNombre.setBackground(Color.BLACK);
			lblNombre.setForeground(Color.RED);
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNombre;
	}

	private JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setBackground(Color.GRAY);
			textFieldNombre.setForeground(Color.WHITE);
			textFieldNombre.setFont(textFieldNombre.getFont().deriveFont(Font.BOLD));
			textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return textFieldNombre;
	}

	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("play");
			btnPlay.setBackground(Color.RED);
			btnPlay.setForeground(Color.BLACK);

		}
		return btnPlay;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("exit");
			btnExit.setBackground(Color.RED);
			btnExit.setForeground(Color.BLACK);

		}
		return btnExit;
	}

	private JLabel getLblLeaderBoard() {
		if (lblLeaderBoard == null) {
			lblLeaderBoard = new JLabel("LeaderBoard");
			lblLeaderBoard.setHorizontalAlignment(SwingConstants.CENTER);
			lblLeaderBoard.setBackground(Color.BLACK);
			lblLeaderBoard.setForeground(Color.WHITE);
		}
		return lblLeaderBoard;
	}

	private JLabel getLblVacio() {
		if (lblVacio == null) {
			lblVacio = new JLabel("");
			lblVacio.setBackground(Color.BLACK);
		}
		return lblVacio;
	}

	private JPanel getPanelAbajo() {
		if (panelAbajo == null) {
			panelAbajo = new JPanel();
			panelAbajo.setBackground(Color.BLACK);
			panelAbajo.setLayout(new GridLayout(0, 2, 0, 0));
			panelAbajo.add(getPanelAbajoIzda());
			panelAbajo.add(getPanelAbajoDer());
		}
		return panelAbajo;
	}

	private JPanel getPanelAbajoIzda() {
		if (panelAbajoIzda == null) {
			panelAbajoIzda = new JPanel();
			panelAbajoIzda.setBackground(Color.BLACK);
			panelAbajoIzda.setLayout(new GridLayout(2, 1, 0, 0));
			panelAbajoIzda.add(getPanelTitulos());
			panelAbajoIzda.add(getPanelRecords());
		}
		return panelAbajoIzda;
	}

	private JPanel getPanelTitulos() {
		if (panelTitulos == null) {
			panelTitulos = new JPanel();
			panelTitulos.setBackground(Color.BLACK);
			panelTitulos.setLayout(new GridLayout(0, 3, 0, 0));
			panelTitulos.add(getLblRank());
			panelTitulos.add(getLblName());
			panelTitulos.add(getLblScore());
		}
		return panelTitulos;
	}

	private JPanel getPanelRecords() {
		if (panelRecords == null) {
			panelRecords = new JPanel();
			panelRecords.setBackground(Color.BLACK);
			panelRecords.setLayout(new GridLayout(5, 3, 0, 0));
		}
		return panelRecords;
	}

	private JLabel getLblRank() {
		if (lblRank == null) {
			lblRank = new JLabel("Rank");
			lblRank.setForeground(Color.RED);
			lblRank.setBackground(Color.BLACK);
			lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblRank;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBackground(Color.BLACK);
			lblName.setForeground(Color.RED);
		}
		return lblName;
	}

	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("Score");
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setBackground(Color.BLACK);
			lblScore.setForeground(Color.RED);
		}
		return lblScore;
	}

	// Comentario
	private JPanel getPanelAbajoDer() {
		if (panelAbajoDer == null) {
			panelAbajoDer = new JPanel();
			panelAbajoDer.setBackground(Color.BLACK);
			panelAbajoDer.add(getLblImagenAbajo());
		}
		return panelAbajoDer;
	}

	private JLabel getLblImagenAbajo() {
		if (lblImagenAbajo == null) {
			lblImagenAbajo = new JLabel("");
		}
		return lblImagenAbajo;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setLayout(new GridLayout(2, 1, 0, 0));
			panel.add(getLblNewLabel_1());
			panel.add(getLblLeaderBoard());
		}
		return panel;
	}

	private JPanel crearPanel(Color pColor, int num) {
		JPanel pnl = new JPanel();
		pnl.setBackground(Color.BLACK);
		pnl.setLayout(new GridLayout(1, 3, 0, 0));
		JLabel lbl1 = new JLabel();
		switch (num) {
			case 1:
				lbl1.setText("1st");
				break;
			case 2:
				lbl1.setText("2nd");
				break;
			case 3:
				lbl1.setText("3rd");
				break;
			case 4:
				lbl1.setText("4th");
				break;
			case 5:
				lbl1.setText("5th");
		}
		lbl1.setForeground(pColor);
		JLabel lbl2 = new JLabel();
		JLabel lbl3 = new JLabel();
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		pnl.add(lbl1);
		pnl.add(lbl2);
		pnl.add(lbl3);
		return pnl;
	}

	private void crearRecords() {
		this.getPanelRecords().add(this.crearPanel(new Color(48, 228, 99), 1));
		this.getPanelRecords().add(this.crearPanel(Color.BLUE, 2));
		this.getPanelRecords().add(this.crearPanel(new Color(255, 112, 230), 3));
		this.getPanelRecords().add(this.crearPanel(new Color(204, 48, 245), 4));
		this.getPanelRecords().add(this.crearPanel(Color.MAGENTA, 5));
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
		}
		return lblNewLabel_1;
	}
}
