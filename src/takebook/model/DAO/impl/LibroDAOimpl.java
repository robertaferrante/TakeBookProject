package takebook.model.DAO.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import takebook.connection.DBConnection;
import takebook.model.Autore;
import takebook.model.Libro;
import takebook.model.DAO.LibroDAO;

//Implementazione dell'interfaccia DAO che estende i suoi metodi alla classe 

public class LibroDAOimpl implements LibroDAO{
	private DBConnection dbConn; 
	
//Nel costruttore richiamiamo la connessione
	public LibroDAOimpl() {	
		dbConn = DBConnection.getDBConnection();
	}
	
	@Override
	public List<Libro> read(String titolo) {
		String q="SELECT * FROM LIBRO WHERE lower(TITOLO) LIKE lower(?)";
		List<Libro> lista_libri = new ArrayList<Libro>();
		try {
			PreparedStatement ps= dbConn.getConnection().prepareStatement(q);
			ps.setString(1,"%"+titolo+"%");
			ResultSet rs= ps.executeQuery();
			while(rs.next()==true) {
				Libro l = new Libro(rs.getInt("id_libro"),rs.getString("titolo"), rs.getString("isbn"), rs.getInt("anno_pubblicazione"),rs.getString("categoria"));
				lista_libri.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista_libri;
	}

	@Override
	public ArrayList<Libro> readAll() {
		String q= "SELECT* FROM LIBRO";
		ArrayList<Libro> lista_libri = new ArrayList<Libro>();
		try {
			PreparedStatement ps= dbConn.getConnection().prepareStatement(q);
			ResultSet rs= ps.executeQuery();
			while(rs.next()==true) {
				Libro l=new Libro();
				l.setId_libro(rs.getInt("id_libro"));
				l.setTitolo(rs.getString("titolo"));
				l.setIsbn(rs.getString("isbn"));
				l.setAnno_pubblicazione(rs.getInt("anno_pubblicazione"));
				l.setCategoria(rs.getString("categoria"));
				lista_libri.add(l);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lista_libri;
	}
	
	public Libro getId(int id_libro) {
		String q = "SELECT * FROM LIBRO WHERE ID_LIBRO=?";
		Libro l= null;
		try {
			PreparedStatement ps = dbConn.getConnection().prepareStatement(q);
			ps.setInt(1, id_libro);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				l = new Libro();
				l.setId_libro(rs.getInt("id_libro"));
				l.setTitolo(rs.getString("titolo"));
				l.setIsbn(rs.getString("isbn"));
				l.setAnno_pubblicazione(rs.getInt("anno_pubblicazione"));
				l.setCategoria(rs.getString("categoria"));	
				l.setData_prenotazione(rs.getDate("data_prenotazione"));
				l.setData_riconsegna(rs.getDate("data_riconsegna"));
				l.setEmail_utente(rs.getString("email_utente"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Autore> getAutoreLibro(String titololibro) {
		List<Autore> listautore = new ArrayList<Autore>();
		String q = "SELECT autore.nome,autore.cognome,autore.nazione from scrive join libro on scrive.id_libro=libro.id_libro join autore on autore.id_autore=scrive.id_autore WHERE libro.titolo=?";
		try {
			PreparedStatement ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, titololibro);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Autore a = new Autore();
				a.setNome(rs.getNString("nome"));
				a.setCognome(rs.getNString("cognome"));
				a.setNazione(rs.getNString("nazione"));
				listautore.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listautore;
	}

	@Override
	public boolean prenota(int id_libro, String email) {
		boolean prenotato = false;
		Libro l = this.getId(id_libro);
		if(l.getEmail_utente() == null) {
			if(id_libro != 0) {
				String q = "UPDATE LIBRO SET DATA_PRENOTAZIONE = '13-giu-2019',DATA_RICONSEGNA = NULL, EMAIL_UTENTE = ?  WHERE ID_LIBRO = ?";
				try {
					PreparedStatement ps = dbConn.getConnection().prepareStatement(q);
					ps.setString(1, email);
					ps.setInt(2, id_libro);
					ps.executeQuery();
					prenotato = true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			prenotato = false;
		}
		return prenotato;
	}

	@Override
	public List<Libro> getPrenotati(String email) {
		String q= "SELECT LIBRO.ID_LIBRO, LIBRO.TITOLO, LIBRO.ISBN, LIBRO.ANNO_PUBBLICAZIONE, LIBRO.CATEGORIA,LIBRO.DATA_PRENOTAZIONE,LIBRO.DATA_RICONSEGNA,LIBRO.EMAIL_UTENTE FROM LIBRO JOIN UTENTE ON LIBRO.EMAIL_UTENTE = UTENTE.EMAIL WHERE UTENTE.EMAIL =?";
		List<Libro> lista_libri = new ArrayList<Libro>();
		try {
			PreparedStatement ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Libro l = new Libro();
				l.setId_libro(rs.getInt("id_libro"));
				l.setTitolo(rs.getString("titolo"));
				l.setIsbn(rs.getString("isbn"));
				l.setAnno_pubblicazione(rs.getInt("anno_pubblicazione"));
				l.setCategoria(rs.getString("categoria"));	
				l.setData_prenotazione(rs.getDate("data_prenotazione"));
				l.setData_riconsegna(rs.getDate("data_riconsegna"));
				l.setEmail_utente(rs.getString("email_utente"));
				lista_libri.add(l);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista_libri;
	}


	@Override
	public boolean restituito(int id_libro) {
		boolean restituito = false;
		Libro l = this.getId(id_libro);
		if(l.getData_prenotazione()!=null) {
			if(id_libro!=0) {
				String q = "UPDATE LIBRO SET DATA_PRENOTAZIONE=NULL, DATA_RICONSEGNA='11-mag-2019',EMAIL_UTENTE = NULL WHERE ID_LIBRO = ?";
				try {
					PreparedStatement ps = dbConn.getConnection().prepareStatement(q);
					ps.setInt(1, id_libro);
					ps.executeQuery();
					restituito = true;
					//ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			restituito=false;
		}
		return restituito;
	}


	@Override
	public ArrayList<Libro> getLibroByCategoria(String categoria) {
		String q="SELECT * FROM LIBRO WHERE lower(categoria) = lower(?)";
		ArrayList<Libro> lista_libri = new ArrayList<Libro>();
		try {
			PreparedStatement ps= dbConn.getConnection().prepareStatement(q);
			ps.setString(1,categoria);
			ResultSet rs= ps.executeQuery();
			while(rs.next()==true) {
				Libro l = new Libro(rs.getInt("id_libro"),rs.getString("titolo"), rs.getString("isbn"), rs.getInt("anno_pubblicazione"),rs.getString("categoria"));
				lista_libri.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista_libri;
	}


	@Override
	public void save(Libro l) {
		
	}


	@Override
	public int update(Libro l) {
		return 0;
	}


	@Override
	public void delete(int id_libro) {
		
	}
	

}