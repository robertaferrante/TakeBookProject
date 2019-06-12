package takebook.model;

public class Autore {
	//Variabili di istanza
	private int id_autore;
	private String nome;
	private String cognome;
	private String nazione;
	
	//Costruttore vuoto
	public Autore() {
		
	}
	
	//Costruttore parametrico
	public Autore(int id_autore, String nome, String cognome, String nazione) {
		this.id_autore=id_autore;
		this.nome=nome;
		this.cognome=cognome;
		this.nazione=nazione;
	}
	
	//Getter e setter
	public int getId_autore() {
		return id_autore;
	}
	public void setId_autore(int id_autore) {
		this.id_autore = id_autore;
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
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
	@Override
	public String toString() {
		return id_autore+" "+nome+" "+cognome+" "+nazione;
	}

}