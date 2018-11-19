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
import java.awt.Font;

public class FrameAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8130991796726750683L;
	private JPanel contentPane;	
	
	public FrameAdmin(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("");
		title.setFont(new Font("Tahoma", Font.PLAIN, 21));
		title.setBounds(83, 11, 515, 33);
		title.setText("Bienvenue administrateur " + ad.getLogin());
		contentPane.add(title);
		
		JButton btnAddGame = new JButton("Ajouter un jeu");
		btnAddGame.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAddGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAddGame fag = new FrameAddGame();
				fag.setVisible(true);
				dispose();
			}
		});
		btnAddGame.setBounds(321, 60, 277, 100);
		contentPane.add(btnAddGame);
		
		JButton btnDeleteGame = new JButton("Supprimer un jeu");
		btnDeleteGame.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnDeleteGame.setBounds(10, 63, 249, 97);
		contentPane.add(btnDeleteGame);
		
		JButton btnChangeUnitCount = new JButton("Modifier nombre unit\u00E9 Joueur");
		btnChangeUnitCount.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnChangeUnitCount.setBounds(96, 176, 390, 48);
		contentPane.add(btnChangeUnitCount);
		
		JButton btnAddPlatform = new JButton("Ajouter une console");
		btnAddPlatform.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAddPlatform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAddPlatform fap = new FrameAddPlatform(ad);
				fap.setVisible(true);
				dispose();
			}
		});
		btnAddPlatform.setBounds(321, 248, 277, 110);
		contentPane.add(btnAddPlatform);
		
		JButton btnDeletePlatform = new JButton("Supprimer une console");
		btnDeletePlatform.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnDeletePlatform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameDeletePlatform fdg = new FrameDeletePlatform(ad);
				fdg.setVisible(true);
				dispose();
			}
		});
		btnDeletePlatform.setBounds(10, 248, 249, 110);
		contentPane.add(btnDeletePlatform);
		
		
	}
}
