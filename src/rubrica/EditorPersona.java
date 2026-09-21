package rubrica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class EditorPersona extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldTelefono;
	private JTextField textFieldIndirizzo;
	private JTextField textFieldEta;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public EditorPersona(Persona persona) {
		setTitle("EDITOR-PERSONA");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		setModal(true);
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel labelTelefono = new JLabel("Telefono");
				labelTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
				labelTelefono.setBounds(0, 91, 193, 34);
				panel.add(labelTelefono);
			}
			{
				JLabel labelNome = new JLabel("Età");
				labelNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
				labelNome.setBounds(1, 179, 192, 33);
				panel.add(labelNome);
			}
			{
				JLabel labelCognome = new JLabel("Cognome");
				labelCognome.setFont(new Font("Tahoma", Font.PLAIN, 16));
				labelCognome.setBounds(0, 53, 192, 33);
				panel.add(labelCognome);
			}
			{
				JLabel labelIndirizzo = new JLabel("Indirizzo");
				labelIndirizzo.setFont(new Font("Tahoma", Font.PLAIN, 16));
				labelIndirizzo.setBounds(1, 135, 192, 33);
				panel.add(labelIndirizzo);
			}
			{
				JLabel lblNome = new JLabel("Nome");
				lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNome.setBounds(0, 0, 192, 33);
				panel.add(lblNome);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			
			textFieldNome = new JTextField(persona.getNome());
			textFieldNome.setBounds(10, 5, 193, 27);
			panel.add(textFieldNome);
			textFieldNome.setColumns(10);
			
			textFieldCognome = new JTextField(persona.getCognome());
			textFieldCognome.setColumns(10);
			textFieldCognome.setBounds(10, 56, 193, 27);
			panel.add(textFieldCognome);
			
			textFieldTelefono = new JTextField(persona.getTelefono());
			textFieldTelefono.setColumns(10);
			textFieldTelefono.setBounds(10, 93, 193, 27);
			panel.add(textFieldTelefono);
			
			textFieldIndirizzo = new JTextField(persona.getIndirizzo());
			textFieldIndirizzo.setColumns(10);
			textFieldIndirizzo.setBounds(10, 142, 193, 27);
			panel.add(textFieldIndirizzo);
			
			textFieldEta = new JTextField(String.valueOf(persona.getEta()));
			textFieldEta.setColumns(10);
			textFieldEta.setBounds(10, 179, 193, 27);
			panel.add(textFieldEta);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salva");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				okButton.addActionListener(e -> {
					
	
					
					if (textFieldNome.getText().compareTo("") == 0 || textFieldCognome.getText().compareTo("") == 0 || textFieldTelefono.getText().compareTo("") == 0 || textFieldIndirizzo.getText().compareTo("") == 0 || textFieldEta.getText().compareTo("0") == 0) {
						JOptionPane.showMessageDialog(null, "Valorizzare tutti i campi, RIPROVA", "ERRORE INSERIMENTO", JOptionPane.ERROR_MESSAGE);
					}else {
					
					persona.setNome(textFieldNome.getText());
					persona.setCognome(textFieldCognome.getText());
					persona.setTelefono(textFieldTelefono.getText());
					persona.setIndirizzo(textFieldIndirizzo.getText());
					persona.setEta(Integer.parseInt(textFieldEta.getText()));
					
					dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancella");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
				cancelButton.addActionListener(event -> {
					dispose();
				});
			}
		}
	}
}
