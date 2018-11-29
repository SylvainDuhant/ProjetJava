package be.duhant.projet;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameMyOrders extends JFrame {
	private static final long serialVersionUID = -1073852621199362147L;
	private JPanel contentPane;
	private JButton btnFinish;

	/**
	 * Create the frame.
	 */
	public FrameMyOrders(Player p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			JList<Order> list = new JList<>(Order.getAll(p));
			list.setFont(new Font("Tahoma", Font.BOLD, 21));
			JScrollPane scrollPane = new JScrollPane(list);
			scrollPane.setBounds(10, 85, 331, 285);
			getContentPane().add(scrollPane);
			scrollPane.setViewportView(list);
			list.setBorder(new LineBorder(new Color(0, 0, 0)));
			list.setSelectedIndex(0);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JCheckBox chckbxPending = new JCheckBox("En cours");
			chckbxPending.setEnabled(false);
			chckbxPending.setFont(new Font("Tahoma", Font.PLAIN, 21));
			chckbxPending.setBounds(417, 94, 145, 23);
			contentPane.add(chckbxPending);
			
			JLabel labelMessage = new JLabel("");
			labelMessage.setForeground(Color.GREEN);
			labelMessage.setFont(new Font("Tahoma", Font.PLAIN, 21));
			labelMessage.setBounds(362, 302, 233, 26);
			contentPane.add(labelMessage);
			
			btnFinish = new JButton("Terminer");
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					list.getSelectedValue().giveBack();
					labelMessage.setText("Jeu rendu");
					chckbxPending.setSelected(list.getSelectedValue().getAccepted());
				}
			});
			btnFinish.setEnabled(false);
			btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 21));
			btnFinish.setBounds(397, 181, 145, 51);
			contentPane.add(btnFinish);
			 chckbxPending.setSelected(list.getSelectedValue().getAccepted());
			 if(list.getSelectedValue().getAccepted()) {
				 btnFinish.setEnabled(true);
			 }
			 else {
				 btnFinish.setEnabled(false);
			 }
			ListSelectionListener listSelectionListener = new ListSelectionListener() {public void valueChanged(ListSelectionEvent listSelectionEvent) {
				 chckbxPending.setSelected(list.getSelectedValue().getAccepted());
				 labelMessage.setText("");
				 if(list.getSelectedValue().getAccepted()) {
					 btnFinish.setEnabled(true);
				 }
				 else {
					 btnFinish.setEnabled(false);
				 }
			 }};
			 list.addListSelectionListener(listSelectionListener);
		}
		catch(Exception err) {
		}
			
			
			
			JLabel lblMesCommandes = new JLabel("Mes commandes");
			lblMesCommandes.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblMesCommandes.setBounds(210, 11, 223, 26);
			contentPane.add(lblMesCommandes);
			
			JButton btnBack = new JButton("Retour");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FramePlayer fp = new FramePlayer(p);
					fp.setVisible(true);
					dispose();
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 21));
			btnBack.setBounds(372, 339, 202, 51);
			contentPane.add(btnBack);		
		
	}
}
