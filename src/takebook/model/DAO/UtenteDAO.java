package takebook.model.DAO;

import takebook.model.Utente;
//Interfaccia che rispetta il pattern DAO e che contiene i principali metodi CRUD  
//Create Read Update Delete; 
public interface UtenteDAO {

	public void save(Utente u);
	public int update(Utente u);
	public boolean delete(String email);
	public Utente read(String email);
	public Utente login(String email,String password);
	public boolean updatePassword(String password, String email);

}