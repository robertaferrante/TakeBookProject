package takebook.model.DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import takebook.connection.DBConnection;
import takebook.model.Autore;
import takebook.model.DAO.AutoreDAO;


public class AutoreDAOimpl implements AutoreDAO {
	private DBConnection dbConn;
	private Statement stm;

	public AutoreDAOimpl() {
		dbConn = DBConnection.getDBConnection();
	}

	@Override
	public Autore read(String nome, String cognome) {
		Autore a = null;
		try {
			String query = "SELECT * FROM AUTORE WHERE nome = '" + nome + "' AND COGNOME ='" + cognome + "'";
			stm = dbConn.getConnection().createStatement();

			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				a = new Autore();
				a.setId_autore(rs.getInt("id_autore"));
				a.setNome(rs.getNString("nome"));
				a.setCognome(rs.getNString("cognome"));
				a.setNazione(rs.getNString("nazione"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	
	@Override
	public ArrayList<Autore> readAll() {
		ArrayList<Autore> ListaAutori = new ArrayList<Autore>();
		String query = "SELECT * FROM Autore";
		Autore a1 = null;
		try {
			stm = dbConn.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				a1 = new Autore(rs.getInt("id_autore"),rs.getString("nome"),rs.getString("cognome"),rs.getString("nazione"));

				ListaAutori.add(a1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListaAutori;

	}
}
