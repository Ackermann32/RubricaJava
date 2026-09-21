package rubrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {

	
	public int access (String user, String password) {
		Connection conn = ConnessioneDB.getConnesione();
		
		String sql = "SELECT * FROM utente WHERE utente.username = ? AND utente.password = ?";
		
		PreparedStatement st;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, user);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			
			if (rs.next())
				return 1;

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nel recupero dati");
		}
		
		return 0;
		
	}
}
