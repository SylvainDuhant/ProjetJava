package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class FrameChangeUnit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1768585322041060486L;
	private JPanel contentPane;
	private JTextField TFUnit;

	/**
	 * Create the frame.
	 */
	public FrameChangeUnit(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<Player> list = new JList<>(Player.getALL());
		list.setFont(new Font("Tahoma", Font.BOLD, 21));
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 10, 350, 250);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TFUnit = new JTextField();
		TFUnit.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFUnit.setBounds(444, 87, 121, 48);
		contentPane.add(TFUnit);
		TFUnit.setColumns(10);
		TFUnit.setText(new Integer(list.getSelectedValue().getUnit()).toString() );
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMessage.setBounds(222, 327, 387, 26);
		contentPane.add(lblMessage);
		
		 ListSelectionListener listSelectionListener = new ListSelectionListener() {public void valueChanged(ListSelectionEvent listSelectionEvent) {
			 TFUnit.setText(new Integer(list.getSelectedValue().getUnit()).toString() );
		 }};
		 list.addListSelectionListener(listSelectionListener);
		JButton btnAply = new JButton("Modifier");
		btnAply.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int newUnit = -1;
				boolean isUnitValid = false;
				try {
					newUnit = Integer.parseInt(TFUnit.getText());
					isUnitValid = true;
				}
				catch(Exception err){
					isUnitValid = false;
					TFUnit.setText("Err");
					lblMessage.setForeground(Color.RED);
					lblMessage.setText("le prix n'est pas valide");
				}
				if(isUnitValid) {
					Player res = list.getSelectedValue().ModifyUnit(newUnit);
					if(res != null) {
						lblMessage.setForeground(Color.GREEN);
						lblMessage.setText("Mise à jour effectuée");
					}
					else {
						lblMessage.setForeground(Color.RED);
						lblMessage.setText("Erreur de base de donnée");
					}
				}
				
			}
		});
		btnAply.setBounds(20, 292, 179, 48);
		contentPane.add(btnAply);
		
		JButton button = new JButton("Retour");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAdmin fa = new FrameAdmin(ad);
				fa.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 21));
		button.setBounds(20, 351, 179, 48);
		contentPane.add(button);
		
	
		
	}

}
