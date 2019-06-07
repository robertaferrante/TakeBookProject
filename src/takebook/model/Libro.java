package takebook.model;

public class Libro {
	//attributi
	private int id_libro;
	private String titolo;
	private String isbn;
	private int anno_pubblicazione;
    private String categoria;
   
    //costruttore vuoto
     public Libro() {

     }
	
     //costruttore con parametri

     public Libro(int id_libro,String titolo,String isbn,int anno_pubblicazione,String categoria) {
    	this.id_libro=id_libro;
    	this.titolo=titolo;
    	this.isbn=isbn;
    	this.anno_pubblicazione=anno_pubblicazione;
    	this.categoria=categoria;
     }
     
    //getter e setter
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getAnno_pubblicazione() {
		return anno_pubblicazione;
	}
	public void setAnno_pubblicazione(int anno_pubblicazione) {
		this.anno_pubblicazione = anno_pubblicazione;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return titolo+" "+isbn+" "+anno_pubblicazione+" "+categoria;
	}


 }