package takebook.model.DAO;

import java.util.ArrayList;
import java.util.List;

import takebook.model.Autore;
import takebook.model.Libro;

public interface LibroDAO {
	
	public void save(Libro l);
	public int update(Libro l);
	public void delete(int id_libro);
	public List<Libro> read(String titolo);
	public Libro getId(int id_libro);
	public ArrayList<Libro> readAll();
	public List<Autore> getAutoreLibro(String titoloLibro);
	public boolean prenota(int id_libro,String email);
	public List<Libro> getPrenotati(String email);
	public boolean restituito(int id_libro);
	public ArrayList<Libro> getLibroByCategoria(String categoria);
	
}
