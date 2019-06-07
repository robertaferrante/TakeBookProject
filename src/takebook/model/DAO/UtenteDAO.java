package takebook.model.DAO;

import takebook.model.Utente;

public interface UtenteDAO {

	public void save(Utente u);
	public int update(Utente u);
	public void delete(String email);
	public Utente read(String email);
	public Utente login(String email,String password);

}