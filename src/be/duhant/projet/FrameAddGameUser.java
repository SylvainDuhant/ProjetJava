package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAddGameUser extends JFrame {
	private JList<Game> list2;
	private JPanel contentPane;
	private JTextField TFName;
	private boolean displayed = false;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public FrameAddGameUser(Player pl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjoutezUnNouveau = new JLabel("Ajoutez un nouveau jeu \u00E0 votre biblioth\u00E8que");
		lblAjoutezUnNouveau.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAjoutezUnNouveau.setBounds(81, 11, 449, 26);
		contentPane.add(lblAjoutezUnNouveau);
		
		JLabel lblNewLabel = new JLabel("Nom du jeu :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 48, 200, 26);
		contentPane.add(lblNewLabel);
		
		TFName = new JTextField();
		TFName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFName.setBounds(220, 48, 389, 27);
		contentPane.add(TFName);
		TFName.setColumns(10);
		
		JList<Platform> list = new JList<>(Platform.getALL());
		list.setFont(new Font("Tahoma", Font.BOLD, 21));
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 85, 200, 200);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(220, 86, 389, 199);
		getContentPane().add(scrollPane2);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMessage.setBounds(198, 288, 396, 26);
		contentPane.add(lblMessage);
		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(displayed){
					GameUser ng = new GameUser(-1,list2.getSelectedValue(), pl, true);
					int res = ng.Create();
					if(res == 1) {
						lblMessage.setForeground(Color.GREEN);
						lblMessage.setText("Ajouté !");
					}
					else {
						lblMessage.setForeground(Color.RED);
						lblMessage.setText("Erreur !");
					}
				}
				else {
					lblMessage.setForeground(Color.RED);
					lblMessage.setText("Selectionnez un jeu");
					
				}
			
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAjouter.setBounds(456, 311, 116, 42);
		contentPane.add(btnAjouter);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FramePlayer fp = new FramePlayer(pl);
				fp.setVisible(true);
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRetour.setBounds(456, 364, 116, 42);
		contentPane.add(btnRetour);
		
		JButton btnFind = new JButton("Chercher");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayed = true;
				list2 = new JList<>(Game.getAll(TFName.getText().toString(),list.getSelectedValue()));
				list2.setFont(new Font("Tahoma", Font.BOLD, 21));
				scrollPane2.setViewportView(list2);
				list2.setBorder(new LineBorder(new Color(0, 0, 0)));
				list2.setSelectedIndex(0);
				list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
					
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnFind.setBounds(20, 311, 238, 76);
		contentPane.add(btnFind);
		

	}
}
