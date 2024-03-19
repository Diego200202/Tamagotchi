package packVista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.Partida;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PantallaPrincipal extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDatos;
	private JLabel lblEvolucion;
	private JLabel lblScore;
	private JPanel panel;
	private JLabel lblPuntos;
	private JButton btnExit;
	private JPanel panelFoto;
	private JLabel lblFoto;
	private JPanel panelCorazones;
	private JLabel lblCorazon1;
	private JLabel lblCorazon2;
	private JLabel lblCorazon3;
	private JLabel lblCorazon4;
	private JPanel panelComida;
	private JLabel lblComida1;
	private JLabel lblComida2;
	private JLabel lblComida3;
	private JLabel lblComida4;
	private JPanel panelAbajo;
	private JPanel panelIzda;
	private JPanel panelDer;
	private JLabel lblCandy;
	private JPanel panelPiruletas;
	private JLabel lblPir1;
	private JLabel lblPir2;
	private JLabel lblPir3;
	private JLabel lblSoup;
	private JPanel panelCucharas;
	private JLabel lblCu1;
	private JLabel lblCu2;
	private JLabel lblCu3;
	private ControladorBtnExit controladorExit;
	private Partida partida;

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal(Partida pPartida) {
		this.partida = pPartida;
		partida.addObserver(this);

		setTitle("Tamagotchi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelDatos(), BorderLayout.NORTH);
		contentPane.add(getPanelFoto(), BorderLayout.CENTER);
		contentPane.add(getPanelCorazones(), BorderLayout.WEST);
		contentPane.add(getPanelComida(), BorderLayout.EAST);
		contentPane.add(getPanelAbajo(), BorderLayout.SOUTH);
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
			lblEvolucion = new JLabel("Egg");
			lblEvolucion.setHorizontalAlignment(SwingConstants.CENTER);
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
			lblPuntos = new JLabel("0");
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
			btnExit.addActionListener(this.getControladorBtnExit());
		}
		return btnExit;
	}
	private JPanel getPanelFoto() {
		if (panelFoto == null) {
			panelFoto = new JPanel();
			panelFoto.setBackground(Color.BLACK);
			panelFoto.add(getLblFoto());
		}
		return panelFoto;
	}
	private JLabel getLblFoto() {
		if (lblFoto == null) {
			lblFoto = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/Egg1.png"));
			lblFoto.setIcon(img);
		}
		return lblFoto;
	}
	private JPanel getPanelCorazones() {
		if (panelCorazones == null) {
			panelCorazones = new JPanel();
			panelCorazones.setBackground(Color.BLACK);
			panelCorazones.setLayout(new GridLayout(0, 1, 0, 0));
			panelCorazones.add(getLblCorazon1());
			panelCorazones.add(getLblCorazon2());
			panelCorazones.add(getLblCorazon3());
			panelCorazones.add(getLblCorazon4());
		}
		return panelCorazones;
	}
	private JLabel getLblCorazon1() {
		if (lblCorazon1 == null) {
			lblCorazon1 = new JLabel("");
			lblCorazon1.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/heart.png"));
			lblCorazon1.setIcon(img);
		}
		return lblCorazon1;
	}
	private JLabel getLblCorazon2() {
		if (lblCorazon2 == null) {
			lblCorazon2 = new JLabel("");
			lblCorazon2.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/heart.png"));
			lblCorazon2.setIcon(img);
		}
		return lblCorazon2;
	}
	private JLabel getLblCorazon3() {
		if (lblCorazon3 == null) {
			lblCorazon3 = new JLabel("");
			lblCorazon3.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/heart.png"));
			lblCorazon3.setIcon(img);
		}
		return lblCorazon3;
	}
	private JLabel getLblCorazon4() {
		if (lblCorazon4 == null) {
			lblCorazon4 = new JLabel("");
			lblCorazon4.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/heart.png"));
			lblCorazon4.setIcon(img);
		}
		return lblCorazon4;
	}
	private JPanel getPanelComida() {
		if (panelComida == null) {
			panelComida = new JPanel();
			panelComida.setBackground(Color.BLACK);
			panelComida.setLayout(new GridLayout(4, 1, 0, 0));
			panelComida.add(getLblComida1());
			panelComida.add(getLblComida2());
			panelComida.add(getLblComida3());
			panelComida.add(getLblComida4());
		}
		return panelComida;
	}
	private JLabel getLblComida1() {
		if (lblComida1 == null) {
			lblComida1 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/hungry.png"));
			lblComida1.setIcon(img);
		}
		return lblComida1;
	}
	private JLabel getLblComida2() {
		if (lblComida2 == null) {
			lblComida2 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/hungry.png"));
			lblComida2.setIcon(img);
		}
		return lblComida2;
	}
	private JLabel getLblComida3() {
		if (lblComida3 == null) {
			lblComida3 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/hungry.png"));
			lblComida3.setIcon(img);
		}
		return lblComida3;
	}
	private JLabel getLblComida4() {
		if (lblComida4 == null) {
			lblComida4 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/hungry.png"));
			lblComida4.setIcon(img);
		}
		return lblComida4;
	}
	private JPanel getPanelAbajo() {
		if (panelAbajo == null) {
			panelAbajo = new JPanel();
			panelAbajo.setBackground(Color.BLACK);
			panelAbajo.setLayout(new GridLayout(0, 2, 0, 0));
			panelAbajo.add(getPanelIzda());
			panelAbajo.add(getPanelDer());
		}
		return panelAbajo;
	}
	private JPanel getPanelIzda() {
		if (panelIzda == null) {
			panelIzda = new JPanel();
			panelIzda.setBackground(Color.BLACK);
			panelIzda.setLayout(new GridLayout(2, 1, 0, 0));
			panelIzda.add(getLblCandy());
			panelIzda.add(getPanelPiruletas());
		}
		return panelIzda;
	}
	private JPanel getPanelDer() {
		if (panelDer == null) {
			panelDer = new JPanel();
			panelDer.setBackground(Color.BLACK);
			panelDer.setLayout(new GridLayout(2, 1, 0, 0));
			panelDer.add(getLblSoup());
			panelDer.add(getPanelCucharas());
		}
		return panelDer;
	}
	private JLabel getLblCandy() {
		if (lblCandy == null) {
			lblCandy = new JLabel("Candy");
			lblCandy.setHorizontalAlignment(SwingConstants.CENTER);
			lblCandy.setForeground(Color.WHITE);
		}
		return lblCandy;
	}
	private JPanel getPanelPiruletas() {
		if (panelPiruletas == null) {
			panelPiruletas = new JPanel();
			panelPiruletas.setBackground(Color.BLACK);
			panelPiruletas.setLayout(new GridLayout(0, 3, 0, 0));
			panelPiruletas.add(getLblPir1());
			panelPiruletas.add(getLblPir2());
			panelPiruletas.add(getLblPir3());
			panelPiruletas.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
		return panelPiruletas;
	}
	private JLabel getLblPir1() {
		if (lblPir1 == null) {
			lblPir1 = new JLabel("");
			lblPir1.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/candy.png"));
			lblPir1.setIcon(img);
		}
		return lblPir1;
	}
	private JLabel getLblPir2() {
		if (lblPir2 == null) {
			lblPir2 = new JLabel("");
			lblPir2.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/candy.png"));
			lblPir2.setIcon(img);
		}
		return lblPir2;
	}
	private JLabel getLblPir3() {
		if (lblPir3 == null) {
			lblPir3 = new JLabel("");
			lblPir3.setBackground(Color.BLACK);
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/candy.png"));
			lblPir3.setIcon(img);
		}
		return lblPir3;
	}
	private JLabel getLblSoup() {
		if (lblSoup == null) {
			lblSoup = new JLabel("Soup");
			lblSoup.setHorizontalAlignment(SwingConstants.CENTER);
			lblSoup.setForeground(Color.WHITE);
		}
		return lblSoup;
	}
	private JPanel getPanelCucharas() {
		if (panelCucharas == null) {
			panelCucharas = new JPanel();
			panelCucharas.setBackground(Color.BLACK);
			panelCucharas.setLayout(new GridLayout(1, 3, 0, 0));
			panelCucharas.add(getLblCu1());
			panelCucharas.add(getLblCu2());
			panelCucharas.add(getLblCu3());
			panelCucharas.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
		return panelCucharas;
	}
	private JLabel getLblCu1() {
		if (lblCu1 == null) {
			lblCu1 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/spoon.png"));
			lblCu1.setIcon(img);
		}
		return lblCu1;
	}
	private JLabel getLblCu2() {
		if (lblCu2 == null) {
			lblCu2 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/spoon.png"));
			lblCu2.setIcon(img);
		}
		return lblCu2;
	}
	private JLabel getLblCu3() {
		if (lblCu3 == null) {
			lblCu3 = new JLabel("");
			ImageIcon img = new ImageIcon(this.getClass().getResource("/imagenes/spoon.png"));
			lblCu3.setIcon(img);
		}
		return lblCu3;
	}

	private ControladorBtnExit getControladorBtnExit() {
		if (controladorExit == null) {
			controladorExit = new ControladorBtnExit();
		}
		return controladorExit;
	}

	private class ControladorBtnExit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource().equals(btnExit)){
				PantallaInicio.getPantallaInicio().setVisible(true);
				partida.terminarPartida(true);
				setVisible(false);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ImageIcon imgCorazonGris = new ImageIcon(this.getClass().getResource("/imagenes/CorazonGris.png"));
		ImageIcon imgCuencoGris = new ImageIcon(this.getClass().getResource("/imagenes/CuencoGris.png"));
		// TODO Auto-generated method stub
		if(arg0 instanceof Partida){
			Object[] array = (Object[]) arg1;
			this.getLblPuntos().setText((int) array[0] +"");
			if((int) array[1] <= 30){
				getLblCorazon1().setIcon(imgCorazonGris);
			}
			if((int) array[2] <= 30) {
				getLblComida1().setIcon(imgCuencoGris);
			}
			if((int) array[2] <= 20) {
				getLblComida2().setIcon(imgCuencoGris);
			}
			if((int) array[2] <= 10) {
				getLblComida3().setIcon(imgCuencoGris);
			}
			if((int) array[2] <= 0) {
				getLblComida4().setIcon(imgCuencoGris);
			}
			ImageIcon imgTamagotchi = new ImageIcon(this.getClass().getResource("/imagenes/"+array[3]+"1.png"));
			getLblEvolucion().setText((String) array[3]);
			getLblFoto().setIcon(imgTamagotchi);
		}
	}
}