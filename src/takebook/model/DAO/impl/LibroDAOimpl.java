package takebook.model.DAO.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import takebook.connection.DBConnection;
import takebook.model.Libro;
import takebook.model.DAO.LibroDAO;



public class LibroDAOimpl implements LibroDAO{
	private DBConnection dbConn; 
	public LibroDAOimpl() {
		
		dbConn = DBConnection.getDBConnection();
	}
	

	@Override
	public Libro read(String titolo) {
		String q="SELECT * FROM LIBRO WHERE TITOLO=?";
		
		Libro l =null;
		try {
			
			PreparedStatement ps= dbConn.getConnection().prepareStatement(q);
			ps.setString(1,titolo);
			ResultSet rs= ps.executeQuery();
			if (rs.next()==true) {
				l=new Libro(rs.getInt("id_libro"),titolo, rs.getInt("isbn"), rs.getInt("anno_pubblicazione"),rs.getString("categoria"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Libro> readAll() {
		
		String q1= "SELECT* FROM LIBRO";
		List<Libro> lista_libri = new ArrayList<Libro>();
		try {
			PreparedStatement ps= dbConn.getConnection().prepareStatement(q1);
			ResultSet rs= ps.executeQuery();
			while(rs.next()==true) {
				
				Libro l1=new Libro();
				l1.setId_libro(rs.getInt("id_libro"));
				l1.setTitolo(rs.getString("titolo"));
				l1.setIsbn(rs.getInt("isbn"));
				l1.setAnno_pubblicazione(rs.getInt("anno_pubblicazione"));
				l1.setCategoria(rs.getString("categoria"));
				
				lista_libri.add(l1);
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		return lista_libri;
	}
	

}