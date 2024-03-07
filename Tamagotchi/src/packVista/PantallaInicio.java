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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelArriba;
	private JLabel lblImagen;
	private JPanel panelMedio;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JButton btnPlay;
	private JButton btnExit;
	private JPanel panelAbajo;
	private JPanel panelLeaderBoard;
	private JLabel lblLeaderBoard;
	private JPanel panelFotos;
	private JPanel panelTitulos;
	private JLabel lblRank;
	private JLabel lblName;
	private JLabel lblScore;
	private JPanel panelRecords;
	private JPanel panelImagenPequeña;
	private JLabel lblImagenGrande;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblImagenPequeña;
	private ControladorBtnPlay controladorPlay;

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
		setTitle("Tamagotchi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelArriba(), BorderLayout.NORTH);
		contentPane.setBackground(Color.BLACK);
		contentPane.add(getPanelMedio(), BorderLayout.CENTER);
		contentPane.add(getPanelAbajo(), BorderLayout.SOUTH);

		this.anadirLabeles();
	}

	private JPanel getPanelArriba() {
		if (panelArriba == null) {
			panelArriba = new JPanel();
			panelArriba.setBackground(Color.BLACK);
			panelArriba.add(getLblImagen());
		}
		return panelArriba;
	}

	private JLabel getLblImagen() {
		if (lblImagen == null) {
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/MainTitle.png"));
			lblImagen = new JLabel(img);
		}
		return lblImagen;
	}

	private JPanel getPanelMedio() {
		if (panelMedio == null) {
			panelMedio = new JPanel();
			panelMedio.setBackground(Color.BLACK);
			panelMedio.setLayout(new GridLayout(1, 4, 0, 0));
			panelMedio.add(getLblNombre());
			panelMedio.add(getTextFieldNombre());
			panelMedio.add(getBtnPlay());
			panelMedio.add(getBtnExit());
		}
		return panelMedio;
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
			btnPlay.addActionListener(this.getControladorBtnPlay());
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

	private JPanel getPanelAbajo() {
		if (panelAbajo == null) {
			panelAbajo = new JPanel();
			panelAbajo.setBackground(Color.BLACK);
			panelAbajo.setLayout(new GridLayout(1, 2, 0, 0));
			panelAbajo.add(getPanelLeaderBoard());
			panelAbajo.add(getPanelFotos());
		}
		return panelAbajo;
	}

	private JPanel getPanelLeaderBoard() {
		if (panelLeaderBoard == null) {
			panelLeaderBoard = new JPanel();
			panelLeaderBoard.setBackground(Color.BLACK);
			panelLeaderBoard.setLayout(new GridLayout(3, 1, 0, 0));
			panelLeaderBoard.add(getLblLeaderBoard());
			panelLeaderBoard.add(getPanelTitulos());
			panelLeaderBoard.add(getPanelRecords());
		}
		return panelLeaderBoard;
	}

	private JLabel getLblLeaderBoard() {
		if (lblLeaderBoard == null) {
			lblLeaderBoard = new JLabel("LeaderBoard");
			lblLeaderBoard.setVerticalAlignment(SwingConstants.BOTTOM);
			lblLeaderBoard.setHorizontalAlignment(SwingConstants.CENTER);
			lblLeaderBoard.setForeground(Color.WHITE);
		}
		return lblLeaderBoard;
	}

	private JPanel getPanelFotos() {
		if (panelFotos == null) {
			panelFotos = new JPanel();
			panelFotos.setBackground(Color.BLACK);
			panelFotos.setLayout(new GridLayout(0, 2, 0, 0));
			panelFotos.add(getPanelImagenPequeña());
			panelFotos.add(getLblImagenGrande());
		}
		return panelFotos;
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

	private JLabel getLblRank() {
		if (lblRank == null) {
			lblRank = new JLabel("Rank");
			lblRank.setHorizontalAlignment(SwingConstants.CENTER);
			lblRank.setForeground(Color.RED);
		}
		return lblRank;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setForeground(Color.RED);
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblName;
	}

	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("Score");
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setForeground(Color.RED);
		}
		return lblScore;
	}

	private JPanel getPanelRecords() {
		if (panelRecords == null) {
			panelRecords = new JPanel();
			panelRecords.setLayout(new GridLayout(5, 3, 5, 5));
			panelRecords.setBackground(Color.BLACK);
		}
		return panelRecords;
	}

	private JPanel getPanelImagenPequeña() {
		if (panelImagenPequeña == null) {
			panelImagenPequeña = new JPanel();
			panelImagenPequeña.setBackground(Color.BLACK);
			panelImagenPequeña.setLayout(new GridLayout(2, 2, 0, 0));
			panelImagenPequeña.add(getLblNewLabel_1());
			panelImagenPequeña.add(getLblNewLabel_2());
			panelImagenPequeña.add(getLblNewLabel_3());
			panelImagenPequeña.add(getLblImagenPequeña());
		}
		return panelImagenPequeña;
	}

	private JLabel getLblImagenGrande() {
		if (lblImagenGrande == null) {
			lblImagenGrande = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/Marutchi1.png"));
			lblImagenGrande.setIcon(img);
		}
		return lblImagenGrande;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
		}
		return lblNewLabel_3;
	}

	private JLabel getLblImagenPequeña() {
		if (lblImagenPequeña == null) {
			lblImagenPequeña = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/gudetama1.gif"));
			lblImagenPequeña.setIcon(img);
		}
		return lblImagenPequeña;
	}

	private JLabel crearLbl() {
		JLabel lbl = new JLabel("");
		lbl.setBackground(Color.BLACK);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		return lbl;
	}

	private void anadirLabeles() {
		List<String> textos = new ArrayList<>();
		textos.add("1st");
		textos.add("2nd");
		textos.add("3rd");
		textos.add("4th");
		textos.add("5th");

		List<Color> colores = new ArrayList<>();
		colores.add(Color.GREEN);
		colores.add(Color.BLUE);
		colores.add(Color.GRAY);
		colores.add(Color.MAGENTA);
		colores.add(Color.PINK);

		for (int i = 0; i < 15; i++) {
			JLabel lbl = crearLbl();
			if (i % 3 == 0) { // Si es el primer JLabel de la fila
				lbl.setText(textos.get(i / 3 % textos.size())); // Asigna el texto correspondiente a cada fila
			}
			lbl.setForeground(colores.get(i / 3 % colores.size()));
			this.getPanelRecords().add(lbl);
		}
	}

	private ControladorBtnPlay getControladorBtnPlay() {
		if(controladorPlay == null) {
			controladorPlay = new ControladorBtnPlay();
		}
		return controladorPlay;
	}
	
	private class ControladorBtnPlay implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			PantallaPrincipal pc = new PantallaPrincipal();
			pc.setVisible(true);
			setVisible(false);
		}
		
	}
}
