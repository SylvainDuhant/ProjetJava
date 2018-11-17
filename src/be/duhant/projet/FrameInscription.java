package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class FrameInscription extends JFrame {

	private JPanel contentPane;
	private JTextField TFLogin;
	private JPasswordField PFPassword;
	private JPasswordField PFConfPassword;
	private JTextField TFEmail;
	private JTextField TGAdresse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInscription frame = new FrameInscription();
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
	public FrameInscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setBounds(172, 11, 131, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login : ");
		lblLogin.setBounds(128, 59, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(83, 84, 98, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblConfirmezLeMot = new JLabel("Confirmez le mot de passe :");
		lblConfirmezLeMot.setBounds(10, 109, 174, 14);
		contentPane.add(lblConfirmezLeMot);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(128, 134, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setBounds(109, 159, 65, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance : ");
		lblDateDeNaissance.setBounds(66, 184, 138, 14);
		contentPane.add(lblDateDeNaissance);
		
		TFLogin = new JTextField();
		TFLogin.setBounds(172, 56, 252, 20);
		contentPane.add(TFLogin);
		TFLogin.setColumns(10);
		
		PFPassword = new JPasswordField();
		PFPassword.setBounds(172, 81, 252, 20);
		contentPane.add(PFPassword);
		
		PFConfPassword = new JPasswordField();
		PFConfPassword.setBounds(172, 109, 252, 20);
		contentPane.add(PFConfPassword);
		
		TFEmail = new JTextField();
		TFEmail.setText("");
		TFEmail.setBounds(172, 134, 252, 20);
		contentPane.add(TFEmail);
		TFEmail.setColumns(10);
		
		TGAdresse = new JTextField();
		TGAdresse.setBounds(172, 159, 252, 20);
		contentPane.add(TGAdresse);
		TGAdresse.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d MMMM yyyy");
		dateChooser.setBounds(172, 184, 252, 20);
		contentPane.add(dateChooser);
	}
}
