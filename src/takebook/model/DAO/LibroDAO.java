package takebook.model.DAO;

import java.util.List;

import takebook.model.Libro;

public interface LibroDAO {


 	//public void save(Libro l);
	//public int update(Libro l);
	//public void delete(int id_libro);
	public Libro read(String titolo);
	public List<Libro> readAll();
}
