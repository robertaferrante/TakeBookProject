package takebook.model.DAO;

import java.util.ArrayList;
import java.util.List;

import takebook.model.Autore;
import takebook.model.Libro;

public interface AutoreDAO {

 	//public void save();
	//public void update();
	//public void delete();
	public ArrayList<Autore>  readAll();
	public Autore read(String nome, String cognome);
	public List<Libro> getLibro(String cognome);
	public ArrayList<Libro> getLibriByAutore(int id_autore);

 }