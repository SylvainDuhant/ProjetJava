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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameDeletePlatform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263350082539377000L;

	/**
	 * Create the frame.
	 */
	public FrameDeletePlatform(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		DAOPlatform daop = new DAOPlatform();
		getContentPane().setLayout(null);
		JList<Platform> list = new JList<>(daop.getAll());
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(55, 0, 304, 195);
		getContentPane().add(scrollPane);
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOPlatform dao = new DAOPlatform();
				dao.delete(list.getSelectedValue().getID());
				((DefaultListModel)list.getModel()).remove(list.getSelectedIndex());
				list.updateUI();
			}
		});
		btnSupprimer.setBounds(158, 206, 89, 23);
		getContentPane().add(btnSupprimer);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAdmin fa = new FrameAdmin(ad);
				fa.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(158, 240, 89, 23);
		getContentPane().add(btnRetour);
	
	}
}
