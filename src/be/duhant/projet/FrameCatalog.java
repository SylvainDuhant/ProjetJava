package be.duhant.projet;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class FrameCatalog extends JFrame {

	private static final long serialVersionUID = -6375660875003259925L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	boolean displayed = false;
	JTextField TFName;
	private JButton btnBack;
	private JButton btnOrder;
	public FrameCatalog(Player p) {
		
		Catalog ca = Catalog.instianciate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultListModel<Game> newList = new DefaultListModel<Game>();
		for(Game val : ca.getListGame())
			newList.addElement(val);
		JList<Game> list = new JList<>(newList);
		list.setFont(new Font("Tahoma", Font.BOLD, 21));
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(20, 11, 380, 345);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JCheckBox chbxAvailable = new JCheckBox("");
		chbxAvailable.setFont(new Font("Tahoma", Font.PLAIN, 21));
		chbxAvailable.setEnabled(false);
		chbxAvailable.setBounds(482, 97, 32, 38);
		chbxAvailable.setSelected(ca.searchFor(list.getSelectedValue()) != null);
		contentPane.add(chbxAvailable);
		 ListSelectionListener listSelectionListener = new ListSelectionListener() {public void valueChanged(ListSelectionEvent listSelectionEvent) {
			 chbxAvailable.setSelected(ca.searchFor(list.getSelectedValue()) != null);
		 }};
		 
		 list.addListSelectionListener(listSelectionListener);
		
		JLabel lblNewLabel = new JLabel("Disponibilité : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(436, 36, 173, 38);
		contentPane.add(lblNewLabel);
		
		
		
		
		btnBack = new JButton("Retour");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FramePlayer fp = new FramePlayer(p);
				fp.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnBack.setBounds(10, 367, 182, 32);
		contentPane.add(btnBack);
		
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMessage.setBounds(399, 285, 220, 38);
		contentPane.add(lblMessage);
		
		btnOrder = new JButton("Commander");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(p.getUnit()>0) {
					GameUser gu = ca.searchFor(list.getSelectedValue());

					if(ca.searchFor(list.getSelectedValue())!=null) { //louer le jeu maintenant
						p.setUnit(p.getUnit()-list.getSelectedValue().getUnit());
						gu.getPlayer().setUnit(gu.getPlayer().getUnit()+list.getSelectedValue().getUnit());
						p.ModifyUnit(p.getUnit());
						Order od = new Order(-1,p, list.getSelectedValue(), gu , new Date(), new Date(), null, true);
						gu.rant();
						od.create();
					}
					else { //vouloir louer le jeu pour plus tard
						Order od = new Order(-1,p, list.getSelectedValue(), new Date(),null, null, false);
						od.create();
					}
					lblMessage.setForeground(Color.GREEN);
					lblMessage.setText("Commande enregistrée");
				}
				else {
					lblMessage.setForeground(Color.RED);
					lblMessage.setText("Pas assez de crédits");
				}
			}
		});
		btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnOrder.setBounds(410, 183, 199, 62);
		contentPane.add(btnOrder);		
	}
}
