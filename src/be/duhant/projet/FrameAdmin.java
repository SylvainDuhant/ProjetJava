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
		title.setBounds(126, 16, 515, 33);
		title.setText("Bienvenue administrateur " + ad.getLogin());
		contentPane.add(title);
		
		JButton btnAddGame = new JButton("Ajouter un jeu");
		btnAddGame.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAddGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAddGame fag = new FrameAddGame(ad);
				fag.setVisible(true);
				dispose();
			}
		});
		btnAddGame.setBounds(321, 60, 298, 70);
		contentPane.add(btnAddGame);
		
		JButton btnDeleteGame = new JButton("Supprimer un jeu");
		btnDeleteGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameDeleteGame fdg = new FrameDeleteGame(ad);
				fdg.setVisible(true);
				dispose();
			}
		});
		btnDeleteGame.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnDeleteGame.setBounds(0, 60, 311, 70);
		contentPane.add(btnDeleteGame);
		
		JButton btnChangeUnitCount = new JButton("Modifier nombre unit\u00E9 Joueur");
		btnChangeUnitCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameChangeUnit fcu = new FrameChangeUnit(ad);
				fcu.setVisible(true);
				dispose();
				}
		});
		btnChangeUnitCount.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnChangeUnitCount.setBounds(0, 149, 311, 70);
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
		btnAddPlatform.setBounds(321, 248, 298, 70);
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
		btnDeletePlatform.setBounds(0, 248, 311, 70);
		contentPane.add(btnDeletePlatform);
		
		JButton btnDelPlay = new JButton("Supprimer Joueur");
		btnDelPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameDeletePlayer fdp = new FrameDeletePlayer(ad);
				fdp.setVisible(true);
				dispose();
			}
		});
		btnDelPlay.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnDelPlay.setBounds(321, 149, 298, 70);
		contentPane.add(btnDelPlay);
		
		
	}
}
