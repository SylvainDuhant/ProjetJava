package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8130991796726750683L;
	private JPanel contentPane;	
	
	public FrameAdmin(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("");
		title.setBounds(127, 11, 239, 14);
		title.setText("Bienvenue administrateur " + ad.getLogin());
		contentPane.add(title);
		
		JButton btnAddGame = new JButton("Ajouter un jeu");
		btnAddGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAddGame fag = new FrameAddGame();
				fag.setVisible(true);
				dispose();
			}
		});
		btnAddGame.setBounds(228, 63, 196, 61);
		contentPane.add(btnAddGame);
		
		JButton btnDeleteGame = new JButton("Supprimer un jeu");
		btnDeleteGame.setBounds(10, 63, 196, 61);
		contentPane.add(btnDeleteGame);
		
		JButton btnChangeUnitCount = new JButton("Modifier nombre unit\u00E9 Joueur");
		btnChangeUnitCount.setBounds(83, 135, 264, 23);
		contentPane.add(btnChangeUnitCount);
		
		JButton btnAddPlatform = new JButton("Ajouter une console");
		btnAddPlatform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAddPlatform fap = new FrameAddPlatform(ad);
				fap.setVisible(true);
				dispose();
			}
		});
		btnAddPlatform.setBounds(228, 169, 196, 61);
		contentPane.add(btnAddPlatform);
		
		JButton btnDeletePlatform = new JButton("Supprimer une console");
		btnDeletePlatform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameDeletePlatform fdg = new FrameDeletePlatform(ad);
				fdg.setVisible(true);
				dispose();
			}
		});
		btnDeletePlatform.setBounds(10, 169, 196, 61);
		contentPane.add(btnDeletePlatform);
		
		
	}
}
