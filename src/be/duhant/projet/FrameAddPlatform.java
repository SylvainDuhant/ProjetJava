package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrameAddPlatform extends JFrame {

	private JPanel contentPane;
	private JTextField TFName;

	/**
	 * Create the frame.
	 */
	public FrameAddPlatform(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjoutDuneConsole = new JLabel("Ajout d'une console");
		lblAjoutDuneConsole.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAjoutDuneConsole.setBounds(193, 16, 296, 27);
		contentPane.add(lblAjoutDuneConsole);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNom.setBounds(92, 97, 84, 39);
		contentPane.add(lblNom);
		
		JLabel lblDateDeSortie = new JLabel("Date de sortie :");
		lblDateDeSortie.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDateDeSortie.setBounds(9, 205, 145, 20);
		contentPane.add(lblDateDeSortie);
		
		TFName = new JTextField();
		TFName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFName.setBounds(169, 90, 384, 52);
		contentPane.add(TFName);
		TFName.setColumns(10);
		
		JDateChooser DCRelease = new JDateChooser();
		DCRelease.setBounds(169, 191, 383, 52);
		contentPane.add(DCRelease);
		
		JLabel lblErr = new JLabel("");
		lblErr.setFont(new Font("Tahoma", Font.PLAIN, 21));
		Color red = new Color(173, 25, 8);
		Color green = new Color(10,115,13) ;
		lblErr.setBounds(138, 347, 338, 30);
		contentPane.add(lblErr);
		
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isDate = false;
				try {
					DCRelease.getDate().toString();
					isDate = true;
				}
				catch(Exception err) {
					isDate = false;
				}
				if(!TFName.getText().toString().equals("")&&isDate) {
					Platform plat = new Platform(-1, TFName.getText().toString(), DCRelease.getDate());
					int res = plat.Create();
					if(res>0) {
						lblErr.setForeground(green);
						lblErr.setText("La Console a été ajoutée !");
					}
					else if(res == -1) {
						lblErr.setForeground(red);
						lblErr.setText("La console existe déjà");
					}
					else {
						lblErr.setForeground(red);
						lblErr.setText("Erreur lors du contact de la base de donnée");
					}
				}
				else {
					lblErr.setForeground(red);
					lblErr.setText("Les champs ne sont pas tous remplis");
				}
				
				
			}
		});
		btnAdd.setBounds(399, 259, 179, 81);
		contentPane.add(btnAdd);
		
		JButton Retour = new JButton("Retour");
		Retour.setFont(new Font("Tahoma", Font.PLAIN, 21));
		Retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAdmin fa = new FrameAdmin(ad);
				fa.setVisible(true);
				dispose();
			}
		});
		Retour.setBounds(15, 259, 179, 81);
		contentPane.add(Retour);

		
	}
}
