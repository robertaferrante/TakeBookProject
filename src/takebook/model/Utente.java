package takebook.model;

public class Utente {
	//attributi
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String citta;
	
	//costruttore vuoto
	public Utente() {

	}
	
	//costruttore con parametri
	public Utente(String email, String password, String nome, String cognome, String indirizzo, String citta) {
		this.email=email;
		this.password=password;
		this.nome=nome;
		this.cognome=cognome;
		this.indirizzo=indirizzo;
		this.citta=citta;
	}

	//getter e setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}


}