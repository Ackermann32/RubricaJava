package rubrica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class RubricaJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modello = new DefaultTableModel();
	

	



	public RubricaJFrame(ArrayList<Persona> p) {
		setTitle("RUBRICA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modello.addColumn("Nome");
		modello.addColumn("Cognome");
		modello.addColumn("Telefono");
		
		for (Persona persona: p) {
			
			Object[] row = {persona.getNome(), persona.getCognome(), persona.getTelefono()};
			
			modello.addRow(row);
		}

		
		JPanel panel = new JPanel();
		panel.setBounds(59, 232, 301, 31);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton addPerson = new JButton("Nuovo");
		panel.add(addPerson);
		
		addPerson.addActionListener(e -> {
			
			
			Persona persona = new Persona("", "", "", "", 0, 0);
			EditorPersona finestra = new EditorPersona(persona);
			finestra.setVisible(true);
            PersonaDAO dao = new PersonaDAO();
			
            if (!persona.getNome().equals("") && !persona.getCognome().equals("") && !persona.getIndirizzo().equals("") && !persona.getTelefono().equals("") && persona.getEta() != 0) {
			dao.inserimento(persona);
	
			p.add(persona);
			Object[] row = {persona.getNome(), persona.getCognome(), persona.getTelefono()};
			modello.addRow(row);
            }
			
		});
		
		JButton changePerson = new JButton("Modifica");
		panel.add(changePerson);
		
		changePerson.addActionListener(e ->{
			int index = table.getSelectedRow();
			
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "Non è stato selezionato nessun contatto, RIPROVA", "ERRORE MODIFICA", JOptionPane.ERROR_MESSAGE);
			}else {
			
			Persona persona = p.get(index);
			
			EditorPersona finestra = new EditorPersona(persona);
			finestra.setVisible(true);
			
			p.remove(index);
			p.add(index, persona);
			Object[] row = {persona.getNome(), persona.getCognome(), persona.getTelefono()};
			modello.setValueAt(persona.getNome(), index, 0);
			modello.setValueAt(persona.getCognome(), index, 1);
			modello.setValueAt(persona.getTelefono(), index, 2);
            PersonaDAO dao = new PersonaDAO();
			
			dao.modifica(persona);
			}
		});
		
		JButton deletePerson = new JButton("Elimina");
		panel.add(deletePerson);
		
		deletePerson.addActionListener(e -> {
			int index = table.getSelectedRow();
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "Non è stato selezionato nessun contatto, RIPROVA", "ERRORE CANCELLAZIONE", JOptionPane.ERROR_MESSAGE);
			}else {
			
			Persona persona = p.get(index);
		
			int scelta = JOptionPane.showConfirmDialog(null, "“Eliminare la persona "+persona.getNome()+" "+persona.getCognome()+"  ?");
			
			
			if (scelta == 0) {
			p.remove(index);
			modello.removeRow(index);
			
			PersonaDAO dao = new PersonaDAO();
			dao.elimina(persona);
			}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 416, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);

		
		
		
		table.setModel(modello);
		scrollPane.setViewportView(table);

	}
}
