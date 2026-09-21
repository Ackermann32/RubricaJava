package rubrica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("LOGIN RUBRICA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(51, 39, 332, 46);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelUsername = new JLabel("Username");
		labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(labelUsername);
		
		textFieldUsername = new JTextField();
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(51, 113, 332, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(labelPassword);
		
		passwordField = new JPasswordField();
		panel_1.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(160, 199, 124, 30);
		contentPane.add(btnLogin);
		
		btnLogin.addActionListener(e -> {
			UtenteDAO utente = new UtenteDAO();
			
			int result = utente.access(textFieldUsername.getText(), new String(passwordField.getPassword()));
			
			if (result == 0) {
				JOptionPane.showMessageDialog(null,"LOGIN ERRATO", "LOGIN ERRATO", JOptionPane.ERROR_MESSAGE);
			}else {
				PersonaDAO dao = new PersonaDAO();
				
				ArrayList<Persona> persone = dao.getData();
				
				RubricaJFrame frame = new RubricaJFrame(persone);
				frame.setVisible(true);
				dispose();
			}
			
		});

	}
}
