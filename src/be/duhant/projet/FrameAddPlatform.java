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

public class FrameAddPlatform extends JFrame {

	private JPanel contentPane;
	private JTextField TFName;

	/**
	 * Create the frame.
	 */
	public FrameAddPlatform(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjoutDuneConsole = new JLabel("Ajout d'une console");
		lblAjoutDuneConsole.setBounds(150, 11, 209, 14);
		contentPane.add(lblAjoutDuneConsole);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(48, 54, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblDateDeSortie = new JLabel("Date de sortie :");
		lblDateDeSortie.setBounds(10, 79, 84, 14);
		contentPane.add(lblDateDeSortie);
		
		TFName = new JTextField();
		TFName.setBounds(104, 51, 86, 20);
		contentPane.add(TFName);
		TFName.setColumns(10);
		
		JDateChooser DCRelease = new JDateChooser();
		DCRelease.setBounds(103, 79, 87, 20);
		contentPane.add(DCRelease);
		
		JLabel lblErr = new JLabel("");
		Color red = new Color(173, 25, 8);
		Color green = new Color(10,115,13) ;
		lblErr.setBounds(111, 198, 248, 14);
		contentPane.add(lblErr);
		
		
		JButton btnAdd = new JButton("Ajouter");
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
					DAOPlatform dao = new DAOPlatform();
					int res = dao.add(plat);
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
		btnAdd.setBounds(101, 120, 89, 23);
		contentPane.add(btnAdd);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAdmin fa = new FrameAdmin(ad);
				fa.setVisible(true);
				dispose();
			}
		});
		Retour.setBounds(101, 154, 89, 23);
		contentPane.add(Retour);

		
	}
}
