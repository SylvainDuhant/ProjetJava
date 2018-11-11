package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JPasswordField password;
	private JLabel lblMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameConnexion frame = new FrameConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBounds(117, 236, 197, 14);
		contentPane.add(lblMessage);
		
		login = new JTextField();
		login.setToolTipText("Login");
		login.setBounds(175, 84, 86, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		password = new JPasswordField();
		password.setToolTipText("Password");
		password.setBounds(175, 139, 86, 20);
		contentPane.add(password);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass = password.getText().toString(); // cryptage possible ici
				String log = login.getText().toString();
				DAOUser dao = new DAOUser();
				int rep = dao.connect(log, pass);
				if(rep != -1 && rep != -2) {
					//connecté
					lblMessage.setText("Vous êtes connecté !");
				}
				else if(rep == -1) {
					//pas connecté
					lblMessage.setText("Mot de passe / Login incorrect");
				}
				else {
					//erreur base de donnée
					lblMessage.setText("Base de donnée indisponible");
				}
				}
		});
		btnConnexion.setBounds(175, 200, 89, 23);
		contentPane.add(btnConnexion);
		
		JLabel lblVousNtesPlus = new JLabel("Vous n'\u00EAtes plus qu'a un click de partager vos jeux ! ");
		lblVousNtesPlus.setBounds(105, 30, 258, 14);
		contentPane.add(lblVousNtesPlus);
	}
}
