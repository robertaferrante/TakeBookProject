package takebook.model.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import takebook.connection.DBConnection;
import takebook.model.Utente;
import takebook.model.DAO.UtenteDAO;



public class UtenteDAOimpl implements UtenteDAO {
	private DBConnection dbConn; //CONNESSIONE AL DATABASE CHE PERMETTE DI INTERROGARLO
	
	
	public UtenteDAOimpl () {
		dbConn = DBConnection.getDBConnection();
	}

	@Override
	public void save(Utente u) {
		String q = "INSERT INTO UTENTE (email, password, nome , cognome, indirizzo, citta) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNome());
			ps.setString(4, u.getIndirizzo());
			ps.setString(5, u.getIndirizzo());
			ps.setString(6, u.getCitta());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Utente read(String email) {
		Utente u = null;
		String q = "SELECT * FROM UTENTE WHERE email = '"+email+"'";
		try {
			Statement stmt = dbConn.getConnection().createStatement();
			ResultSet rs =stmt.executeQuery(q);
			
			if(rs.next()) {
				u = new Utente (email, rs.getString("password"),rs.getString("nome"),rs.getString("cognome"),rs.getString("indirizzo"),rs.getString("citta"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
		
		
	}

	@Override
	public int update(Utente u) {
		int numeroRighe = 0;
		String q ="UPDATE utente SET  password = ?, nome = ?, cognome = ?, indirizzo = ?, citta = ? WHERE email = ?";
		try {
			PreparedStatement ps = dbConn.getConnection().prepareStatement(q);
			
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getCognome());
			ps.setString(4, u.getIndirizzo());
			ps.setString(5, u.getCitta());
			ps.setString(6, u.getEmail());
			numeroRighe = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return numeroRighe;
		
	}

	@Override
	public void delete(String email) {
		String q = "DELETE FROM utente WHERE email = '"+email+"'";
		try {
			Statement stmt = dbConn.getConnection().createStatement();
			stmt.executeQuery(q);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public Utente login(String email, String password) {
		Utente u = null;
		String q = "SELECT * FROM UTENTE WHERE email = ? AND PASSWORD = ?";
		try {
			PreparedStatement ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			 if(rs.next()) {
				u = new Utente (email, password,rs.getString("nome"),rs.getString("cognome"),rs.getString("indirizzo"),rs.getString("citta"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
		
	}

}