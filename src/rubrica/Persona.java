package rubrica;

public class Persona {

	public Persona (String nome_persona, String cognome_persona, String indirizzo_persona, String telefono_persona, int eta_persona, int id_persona) {
		this.nome = nome_persona;
		this.cognome = cognome_persona;
		this.indirizzo = indirizzo_persona;
		this.telefono = telefono_persona;
		this.eta = eta_persona;
		this.id = id_persona;
		
	}
	
	
	public String getNome () {
		return this.nome;
	}
	
	public String getCognome () {
		return this.cognome;
	}
	
	public String getIndirizzo () {
		return this.indirizzo;
	}
	
	public String getTelefono () {
		return this.telefono;
	}
	
	public int getEta () {
		return this.eta;
	}
	
	public int getId () {
		return this.id;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public void setCognome (String cognome) {
		this.cognome = cognome;
	}
	
	public void setIndirizzo (String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public void setTelefono (String telefono) {
		this.telefono = telefono;
	}
	
	public void setEta (int eta) {
		this.eta = eta;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	
	
	
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private int eta;
	private int id;
}
