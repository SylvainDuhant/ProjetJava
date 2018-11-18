package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton but_co = new JButton("Connexion");
		but_co.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameConnexion fc = new FrameConnexion();
				fc.setVisible(true);
				dispose();
			}
		});
		but_co.setBounds(10, 100, 134, 23);
		contentPane.add(but_co);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameInscription fi = new FrameInscription();
				fi.setVisible(true);
				dispose();
			}
		});
		btnInscription.setBounds(283, 100, 141, 23);
		contentPane.add(btnInscription);
		
		JLabel lblTitre = new JLabel("Nouveau  venu ? Inscrivez vous !");
		lblTitre.setBounds(122, 36, 282, 14);
		contentPane.add(lblTitre);
	}
}
