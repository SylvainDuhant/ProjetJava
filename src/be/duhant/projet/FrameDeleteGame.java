package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class FrameDeleteGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263350082539377000L;
	private JTextField TFPrice;

	/**
	 * Create the frame.
	 */
	public FrameDeleteGame(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		getContentPane().setLayout(null);
		JList<Game> list = new JList<>(Game.getAll());
		list.setFont(new Font("Tahoma", Font.BOLD, 21));
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(120, 10, 350, 250);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMessage.setBounds(409, 318, 200, 35);
		getContentPane().add(lblMessage);

		TFPrice = new JTextField();
		TFPrice.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFPrice.setBounds(496, 149, 113, 35);
		getContentPane().add(TFPrice);
		TFPrice.setColumns(10);
		
		 ListSelectionListener listSelectionListener = new ListSelectionListener() {public void valueChanged(ListSelectionEvent listSelectionEvent) {
			 TFPrice.setText(new Integer(list.getSelectedValue().getUnit()).toString());
		 }};
		 TFPrice.setText(new Integer(list.getSelectedValue().getUnit()).toString());
		 list.addListSelectionListener(listSelectionListener);
		 list.addListSelectionListener(listSelectionListener);
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.getSelectedValue().delete();
				((DefaultListModel)list.getModel()).remove(list.getSelectedIndex());
				list.updateUI();
			}
		});
		btnSupprimer.setBounds(202, 291, 197, 35);
		getContentPane().add(btnSupprimer);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAdmin fa = new FrameAdmin(ad);
				fa.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(202, 342, 197, 35);
		getContentPane().add(btnRetour);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					list.getSelectedValue().UpdatePrice(Integer.parseInt(TFPrice.getText()));
					lblMessage.setForeground(Color.GREEN);
					lblMessage.setText("Modification effectuée");
				}
				catch(Exception err){
					lblMessage.setForeground(Color.RED);
					lblMessage.setText("Prix non valide");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(496, 225, 113, 35);
		getContentPane().add(btnNewButton);
		

		
	
	}
}
