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

import takebook.model.Utente;
import takebook.model.DAO.UtenteDAO;
import takebook.model.DAO.impl.UtenteDAOimpl;



/**
 * Servlet implementation class ServletIndex
 */
	@WebServlet("/ServletIndex")
	public class ServletIndex extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private static UtenteDAO utDAO;
	
	public void init(ServletConfig config) throws ServletException{
	    	ServletIndex.utDAO = new UtenteDAOimpl();
	    	
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();

		if(utDAO.login(email, pass)==null){  
	        request.setAttribute("err", 1);
	        RequestDispatcher rd = request.getRequestDispatcher("./VIEW/index.jsp");  
	        rd.include(request,response);  
	    }  else {
			Utente u = utDAO.login(email, pass);
			session.setAttribute("email" ,email);
			session.setAttribute("nome", u.getNome());
			session.setAttribute("cognome", u.getCognome());
			
			RequestDispatcher d = request.getRequestDispatcher("./VIEW/Menu.jsp");
			d.forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
