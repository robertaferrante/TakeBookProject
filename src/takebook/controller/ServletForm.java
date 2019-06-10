package takebook.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import takebook.controller.ServletForm;
import takebook.model.Utente;
import takebook.model.DAO.UtenteDAO;
import takebook.model.DAO.impl.UtenteDAOimpl;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtenteDAO utDAO;
    
	
	 public void init(ServletConfig config) throws ServletException{
	    	ServletForm.utDAO = new UtenteDAOimpl();
	    	
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForm() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String citta = request.getParameter("citta");
		String indirizzo = request.getParameter("indirizzo");
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		Utente u = new Utente(email, password, nome, cognome, indirizzo, citta);
		HttpSession session = request.getSession();

		
		if(utDAO.read(email)!=null){
	        request.setAttribute("err", 2);
	        RequestDispatcher rd = request.getRequestDispatcher("./formregistrazione.jsp");  
	        rd.include(request,response);  
	    }  else {
			utDAO.save(u);
			session.setAttribute("email" ,u.getEmail());
			session.setAttribute("psw" ,u.getPassword());
			session.setAttribute("nome", u.getNome());
			session.setAttribute("cognome", u.getCognome());
			session.setAttribute("indirizzo", u.getIndirizzo());
			session.setAttribute("citta", u.getCitta());
			RequestDispatcher d = request.getRequestDispatcher("./VIEW/Menu.jsp");
			d.forward(request, response);
		    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}