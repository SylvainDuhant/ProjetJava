package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrameConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JPasswordField password;
	private JLabel lblMessage;


	/**
	 * Create the frame.
	 */
	public FrameConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBounds(125, 59, 197, 14);
		Color red = new Color(173, 25, 8);
		lblMessage.setForeground(red);
		contentPane.add(lblMessage);
		
		login = new JTextField();
		login.setFont(new Font("Tahoma", Font.PLAIN, 21));
		login.setToolTipText("Login");
		login.setBounds(175, 89, 393, 39);
		contentPane.add(login);
		login.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 21));
		password.setToolTipText("Password");
		password.setBounds(175, 166, 393, 39);
		contentPane.add(password);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass = password.getText().toString(); // cryptage possible ici
				String log = login.getText().toString();;
				if(!pass.equals("") && !log.equals("")) {
					int rep = User.Login(log, pass);
					if(rep != -1 && rep != -2) {
						//connecté
						lblMessage.setText("Vous êtes connecté !");
						User u = User.Find(rep);
						if(u instanceof Admin) {
							FrameAdmin fa = new FrameAdmin((Admin) u);
							fa.setVisible(true);
							dispose();
						}
						else {
							FramePlayer f = new FramePlayer((Player) u);
							f.setVisible(true);
							dispose();
						}
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
				else {
					lblMessage.setText("Certains champs ne sont pas remplis");
				}
			}
		});
		btnConnexion.setBounds(147, 221, 303, 70);
		contentPane.add(btnConnexion);
		
		JLabel lblVousNtesPlus = new JLabel("Vous n'\u00EAtes plus qu'a un click de partager vos jeux ! ");
		lblVousNtesPlus.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblVousNtesPlus.setBounds(63, 28, 571, 26);
		contentPane.add(lblVousNtesPlus);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame mf = new MainFrame();
				mf.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(147, 307, 303, 70);
		contentPane.add(btnRetour);
		
		JLabel lblLogin = new JLabel("Login : ");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblLogin.setBounds(63, 89, 133, 31);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPassword.setBounds(27, 170, 133, 31);
		contentPane.add(lblPassword);
	}
}
