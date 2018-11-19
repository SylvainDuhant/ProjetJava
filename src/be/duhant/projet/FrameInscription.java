package be.duhant.projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrameInscription extends JFrame {

	private JPanel contentPane;
	private JTextField TFLogin;
	private JPasswordField PFPassword;
	private JPasswordField PFConfPassword;
	private JTextField TFEmail;
	private JTextField TGAdresse;
	
	/**
	 * Create the frame.
	 */
	public FrameInscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(234, 16, 160, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login : ");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblLogin.setBounds(58, 48, 138, 32);
		contentPane.add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMotDePasse.setBounds(58, 99, 179, 22);
		contentPane.add(lblMotDePasse);
		
		JLabel lblConfirmezLeMot = new JLabel("Confirmez le mot de passe :");
		lblConfirmezLeMot.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblConfirmezLeMot.setBounds(0, 137, 281, 32);
		contentPane.add(lblConfirmezLeMot);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblEmail.setBounds(58, 192, 105, 32);
		contentPane.add(lblEmail);
		
		JLabel lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAdresse.setBounds(55, 240, 141, 34);
		contentPane.add(lblAdresse);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance : ");
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDateDeNaissance.setBounds(25, 297, 229, 25);
		contentPane.add(lblDateDeNaissance);
		
		TFLogin = new JTextField();
		TFLogin.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFLogin.setBounds(327, 48, 271, 32);
		contentPane.add(TFLogin);
		TFLogin.setColumns(10);
		
		PFPassword = new JPasswordField();
		PFPassword.setFont(new Font("Tahoma", Font.PLAIN, 21));
		PFPassword.setBounds(327, 94, 271, 32);
		contentPane.add(PFPassword);
		
		PFConfPassword = new JPasswordField();
		PFConfPassword.setFont(new Font("Tahoma", Font.PLAIN, 21));
		PFConfPassword.setBounds(327, 136, 271, 35);
		contentPane.add(PFConfPassword);
		
		TFEmail = new JTextField();
		TFEmail.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TFEmail.setText("");
		TFEmail.setBounds(327, 189, 271, 35);
		contentPane.add(TFEmail);
		TFEmail.setColumns(10);
		
		TGAdresse = new JTextField();
		TGAdresse.setFont(new Font("Tahoma", Font.PLAIN, 21));
		TGAdresse.setBounds(327, 242, 271, 32);
		contentPane.add(TGAdresse);
		TGAdresse.setColumns(10);
		
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(117, 36, 277, 14);
		Color red = new Color(173, 25, 8);
		lblError.setForeground(red);
		contentPane.add(lblError);
		
		JDateChooser DPBirthday = new JDateChooser();
		DPBirthday.setDateFormatString("EEEE d MMMM yyyy");
		DPBirthday.setBounds(327, 290, 271, 32);
		contentPane.add(DPBirthday);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isDateSet = false;
				try {
					DPBirthday.getDate().toString();
					isDateSet = true;
				}
				catch(Exception err) {
					isDateSet = false;
				}
				if(!PFPassword.getText().equals(PFConfPassword.getText())) {
					lblError.setText("Les mots de passes ne correspondent pas !");					
				}	
				else if(TFLogin.getText().equals("") || PFPassword.getText().equals("") || TFEmail.getText().equals("") || TGAdresse.getText().equals("") || !isDateSet ) {
					lblError.setText("Certains champs ne sont pas remplis !");
				}
				else {
					DAOUser dao = new DAOUser();
					Player pl = new Player(-1, PFPassword.getText() ,TFLogin.getText(), TFEmail.getText(), TGAdresse.getText(), DPBirthday.getDate() , 10, new Date());
					int res = dao.add(pl);
					if(res > 0) {
						pl.SetID(res);
						FramePlayer f = new FramePlayer(pl);
						f.setVisible(true);
						dispose();
					}
					else if(res == -1) {
						lblError.setText("Le login est déjà utilisé");
					}
					else {
						lblError.setText("Erreur lors du contact de la base de donnée");
					}
				}
				
			}
		});
		btnInscription.setBounds(393, 338, 160, 55);
		contentPane.add(btnInscription);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame();
				mf.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(25, 338, 160, 55);
		contentPane.add(btnRetour);
	
	}
}
