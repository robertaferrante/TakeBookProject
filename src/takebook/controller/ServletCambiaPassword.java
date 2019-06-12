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

import takebook.checkLogin.CheckLogin;
import takebook.model.DAO.UtenteDAO;
import takebook.model.DAO.impl.UtenteDAOimpl;

/**
 * Servlet implementation class ServletCambiaPassword
 */
@WebServlet("/ServletCambiaPassword")
public class ServletCambiaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtenteDAO utDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ServletCambiaPassword() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException{
    	ServletCambiaPassword.utDAO = new UtenteDAOimpl();	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckLogin.checkLogin(request, response);
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String pswnew = request.getParameter("pswnew");
		boolean cambiato = utDAO.updatePassword(pswnew, email);
		request.setAttribute("nuovapassword", utDAO.updatePassword(pswnew, email));
		request.setAttribute("cambiato", cambiato);
		RequestDispatcher rd = request.getRequestDispatcher("./VIEW/areapersonale.jsp");  
	    rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
