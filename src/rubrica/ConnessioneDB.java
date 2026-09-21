package rubrica;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Properties;

public class ConnessioneDB {

	private static Connection connessione = null;
	
	
	public static Connection getConnesione() {
		if (connessione == null) {
			try {
				Properties props = new Properties();
				FileInputStream in = new FileInputStream("credenziali_database.properties");
				props.load(in);
				in.close();
				
				
				connessione = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
				System.out.println("Connessione al database stabilita con successo");
			} catch (IOException e) {
				System.out.println("Errore nella lettura del file .properties");
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Errore nella connessione al db");
			}
		}
		
		return connessione;
	}
	
}
