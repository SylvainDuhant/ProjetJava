package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class FrameAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8130991796726750683L;
	private JPanel contentPane;	
	
	public FrameAdmin(Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("");
		title.setBounds(78, 11, 239, 14);
		title.setText("Bienvenue administrateur " + ad.getLogin());
		contentPane.add(title);
		
		
	}

}
