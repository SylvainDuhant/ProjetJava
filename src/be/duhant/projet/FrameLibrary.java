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
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameLibrary extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1826587537964148882L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrameLibrary(Player pl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxAvailable = new JCheckBox("\u00E0 louer");
		chckbxAvailable.setFont(new Font("Tahoma", Font.PLAIN, 21));
		chckbxAvailable.setBounds(496, 42, 97, 23);
		contentPane.add(chckbxAvailable);
		
		JLabel lblMess = new JLabel("");
		lblMess.setForeground(Color.GREEN);
		lblMess.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMess.setBounds(95, 270, 411, 35);
		contentPane.add(lblMess);

		JList<GameUser> list = new JList<>(pl.getAllGameUser());
		list.setFont(new Font("Tahoma", Font.BOLD, 21));
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(120, 10, 350, 250);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent listSelectionEvent) {
			chckbxAvailable.setSelected(list.getSelectedValue().getAvailability());
		 }});
		chckbxAvailable.setSelected(list.getSelectedValue().getAvailability());
		
		JButton btnUpdate = new JButton("Valider");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.getSelectedValue().changeAvailability(chckbxAvailable.isSelected());
				lblMess.setText("Modification sauvegardée");
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnUpdate.setBounds(480, 115, 113, 46);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Retour");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FramePlayer fp = new FramePlayer(pl);
				fp.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnBack.setBounds(195, 329, 170, 70);
		contentPane.add(btnBack);
		

		

	}
}
