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

import takebook.model.DAO.UtenteDAO;
import takebook.model.DAO.impl.UtenteDAOimpl;

/**
 * Servlet implementation class ServletEliminaAccount
 */
@WebServlet("/ServletEliminaAccount")
public class ServletEliminaAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtenteDAO utDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminaAccount() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	ServletEliminaAccount.utDAO = new UtenteDAOimpl();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		boolean eliminato =  utDAO.delete(email);

		request.setAttribute("eliminato", eliminato);
		RequestDispatcher d = request.getRequestDispatcher("./welcome.html");
		d.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
