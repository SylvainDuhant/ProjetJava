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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameDeletePlayer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3432529283252035793L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public FrameDeletePlayer(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<Player> list = new JList<>(Player.getALL());
		list.setFont(new Font("Tahoma", Font.BOLD, 21));
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(50, 10, 500, 300);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnDeletePlayer = new JButton("Supprimer");
		btnDeletePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					list.getSelectedValue().delete();
					((DefaultListModel<Player>)list.getModel()).remove(list.getSelectedIndex());
					list.updateUI();
			}
		});
		btnDeletePlayer.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnDeletePlayer.setBounds(217, 321, 131, 35);
		contentPane.add(btnDeletePlayer);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAdmin fa = new FrameAdmin(ad);
				fa.setVisible(true);
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRetour.setBounds(217, 367, 131, 32);
		contentPane.add(btnRetour);
		
	}

}
