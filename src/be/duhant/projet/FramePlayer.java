package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePlayer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FramePlayer(Player p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitre = new JLabel("Bienvenue " + p.getLogin());
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblTitre.setBounds(117, 11, 502, 54);
		contentPane.add(lblTitre);
		
		JButton btnaddGame = new JButton("Ajouter un jeu");
		btnaddGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAddGameUser fagu = new FrameAddGameUser(p);
				fagu.setVisible(true);
				dispose();
			}
		});
		btnaddGame.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnaddGame.setBounds(10, 76, 204, 66);
		contentPane.add(btnaddGame);
		
		JButton btnLibrary = new JButton("Biblioth\u00E8que");
		btnLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameLibrary fl = new FrameLibrary(p);
				fl.setVisible(true);
				dispose();
			}
		});
		btnLibrary.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnLibrary.setBounds(405, 76, 204, 66);
		contentPane.add(btnLibrary);
	}
}
