package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		setBounds(100, 100, 930, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton but_co = new JButton("Connexion");
		but_co.setFont(new Font("Segoe UI", Font.BOLD, 40));
		but_co.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameConnexion fc = new FrameConnexion();
				fc.setVisible(true);
				dispose();
			}
		});
		but_co.setBounds(42, 204, 309, 110);
		contentPane.add(but_co);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.setFont(new Font("Segoe UI", Font.BOLD, 40));
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameInscription fi = new FrameInscription();
				fi.setVisible(true);
				dispose();
			}
		});
		btnInscription.setBounds(594, 204, 308, 110);
		contentPane.add(btnInscription);
		
		JLabel lblTitre = new JLabel("Nouveau  venu ? Inscrivez vous !");
		lblTitre.setFont(new Font("Segoe UI", Font.PLAIN, 44));
		lblTitre.setBounds(97, 13, 880, 146);
		contentPane.add(lblTitre);
	}
}
