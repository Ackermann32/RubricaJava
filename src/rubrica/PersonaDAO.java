package rubrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonaDAO {

	public void inserimento(Persona p) {
		Connection conn = ConnessioneDB.getConnesione();
		
		String sql = "INSERT INTO Persona (nome, cognome, telefono, indirizzo, eta) VALUES\r\n"
				+ "(?,?,?,?,?)";
		
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, p.getNome());
			st.setString(2, p.getCognome());
			st.setString(3, p.getTelefono());
			st.setString(4, p.getIndirizzo());
			st.setInt(5, p.getEta());
			st.executeUpdate();
			
			try (ResultSet generatedKeys = st.getGeneratedKeys()){
				if (generatedKeys.next()) {
					int nuovoId = generatedKeys.getInt(1);
					
					p.setId(nuovoId);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nell'inserimento del contatto");
		}	
		
	}
	
	
	public void modifica(Persona p) {
		Connection conn = ConnessioneDB.getConnesione();
		
		String sql = "UPDATE Persona SET nome = ? , cognome = ?, telefono = ?, indirizzo = ?, eta = ? WHERE id = ?";
		
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, p.getNome());
			st.setString(2, p.getCognome());
			st.setString(3, p.getTelefono());
			st.setString(4, p.getIndirizzo());
			st.setInt(5, p.getEta());
			st.setInt(6, p.getId());
			
			st.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nell'aggiornamento");
		}	
		
	}
	
	public void elimina(Persona p) {
		Connection conn = ConnessioneDB.getConnesione();
		
		String sql = "DELETE FROM Persona WHERE id = ?";
		
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, p.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nella cancellazione");
		}	
		
	}
	
	public ArrayList<Persona> getData(){
		Connection conn = ConnessioneDB.getConnesione();
		ArrayList <Persona> persone = new ArrayList<>();
		String sql = "SELECT * FROM persona";
		
		Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore con la creazione dello statment");
		}
		
		try {
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {

				Persona newPersona = new Persona(rs.getString("nome"), rs.getString("cognome"), rs.getString("indirizzo"), rs.getString("telefono"), rs.getInt("eta"), rs.getInt("id"));
					
					persone.add(newPersona);

			}
			
			return persone;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nel recupero dati");
		}
		
		return null;
	}
	

	
	
}
