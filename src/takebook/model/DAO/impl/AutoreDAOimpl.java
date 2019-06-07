package takebook.model.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import takebook.connection.DBConnection;
import takebook.model.Autore;
import takebook.model.Libro;
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
			e.printStackTrace();
		}
		return ListaAutori;

	}

	@Override
	public List<Libro> getLibro(String nome, String cognome) {
		List<Libro> listaLibro = new ArrayList<Libro>();
		
		String q = "SELECT * from scrive join libro on scrive.id_libro=libro.id_libro join autore on autore.id_autore=scrive.id_autore WHERE autore.nome=? AND autore.cognome=?";
		try {
			PreparedStatement ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Libro l = new Libro(rs.getInt("id_libro"),rs.getString("titolo"), rs.getString("isbn"), rs.getInt("anno_pubblicazione"),rs.getString("categoria"));
				listaLibro.add(l);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return listaLibro;
	}
}
