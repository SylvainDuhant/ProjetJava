package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameAddGame extends JFrame {
//Game(int ID,Platform plat, int unit, String name, String developers, String editor )
	private JPanel contentPane;
	private JTextField TFUnit;
	private JTextField TFDev;
	private JTextField TFName;
	private JTextField TFEd;
	/**
	 * Create the frame.
	 */
	public FrameAddGame(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAdmin fa = new FrameAdmin(ad);
				fa.setVisible(true);
				dispose();
			}
		});
		DAOPlatform daop = new DAOPlatform();
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRetour.setBounds(344, 373, 129, 26);
		contentPane.add(btnRetour);
		JList<Platform> list = new JList<>(daop.getAll());
		list.setBounds(209, 11, 302, 193);
		list.setFont(new Font("Tahoma", Font.BOLD, 21));
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(55, 0, 500, 150);
		getContentPane().add(scrollPane);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNom.setBounds(21, 215, 76, 39);
		contentPane.add(lblNom);
		
		JLabel lblEditeur = new JLabel("Editeur : ");
		lblEditeur.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblEditeur.setBounds(21, 302, 116, 31);
		contentPane.add(lblEditeur);
		
		JLabel lblDeveloppeur = new JLabel("Developpeur : ");
		lblDeveloppeur.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDeveloppeur.setBounds(21, 265, 154, 26);
		contentPane.add(lblDeveloppeur);
		
		JLabel lblPrixDuJeu = new JLabel("Prix du jeu :");
		lblPrixDuJeu.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPrixDuJeu.setBounds(21, 172, 116, 26);
		contentPane.add(lblPrixDuJeu);
		
		TFUnit = new JTextField();
		TFUnit.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFUnit.setBounds(169, 172, 304, 26);
		contentPane.add(TFUnit);
		TFUnit.setColumns(10);
		
		TFDev = new JTextField();
		TFDev.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFDev.setColumns(10);
		TFDev.setBounds(169, 265, 304, 26);
		contentPane.add(TFDev);
		
		TFName = new JTextField();
		TFName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFName.setColumns(10);
		TFName.setBounds(169, 221, 304, 26);
		contentPane.add(TFName);
		
		TFEd = new JTextField();
		TFEd.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFEd.setColumns(10);
		TFEd.setBounds(169, 304, 304, 26);
		contentPane.add(TFEd);
		
		JLabel lblErr = new JLabel("");
		lblErr.setForeground(Color.RED);
		lblErr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblErr.setBounds(10, 344, 324, 55);
		contentPane.add(lblErr);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isUnitValid = false;
				int unit = 0;
				try {
					unit = Integer.parseInt(TFUnit.getText().toString());
					isUnitValid = true;
				}
				catch(Exception err) {
					isUnitValid = false;
					
				}
				if(isUnitValid && !TFName.getText().toString().equals("") && !TFEd.getText().toString().equals("") && !TFDev.getText().toString().equals("") ) {
					Game g = new Game(-1, list.getSelectedValue() , unit, TFName.getText().toString(), TFDev.getText().toString(),TFEd.getText().toString());
					int res = g.add();
					if(res >-1) {
						lblErr.setForeground(Color.GREEN);
						lblErr.setText("Jeu ajouté");
					}
					else if (res == -1){
						lblErr.setForeground(Color.RED);
						lblErr.setText("Le jeu existe déjà");
					}
					else {
						lblErr.setForeground(Color.RED);
						lblErr.setText("Erreur de base de donnée");
					}
				}
				else {
					lblErr.setForeground(Color.RED);
					if(isUnitValid) {
						lblErr.setText("Les champs ne sont pas tous remplis !");
					}
					else {
						lblErr.setText("Prix non valide !");
						
					}
					
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAdd.setBounds(344, 341, 129, 26);
		contentPane.add(btnAdd);
		

	}
}
