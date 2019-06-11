package takebook.main;

import takebook.model.Libro;
import takebook.model.DAO.impl.LibroDAOimpl;

public class TakebookMain {

	public static void main(String[] args) {
		
		Libro l = new Libro();
		LibroDAOimpl ldi = new LibroDAOimpl();

		
		System.out.println(ldi.getPrenotati("d.ascione@gmail.com"));
		
		
	}

}
