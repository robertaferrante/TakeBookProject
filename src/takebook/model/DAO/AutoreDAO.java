package takebook.model.DAO;

import java.util.ArrayList;


import takebook.model.Autore;

public interface AutoreDAO {

 	//public void save();
	//public void update();
	//public void delete();
	public ArrayList<Autore>  readAll();
	public Autore read(String nome, String cognome);

 }