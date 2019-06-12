package takebook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import takebook.checkLogin.CheckLogin;
import takebook.model.DAO.LibroDAO;
import takebook.model.DAO.impl.LibroDAOimpl;

/**
 * Servlet implementation class ServletPrenota
 */
@WebServlet("/ServletPrenota")
public class ServletPrenota extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LibroDAO libDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ServletPrenota() {
        super(); 
    }
    
    public void init(ServletConfig config) throws ServletException{
    	ServletPrenota.libDAO = new LibroDAOimpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckLogin.checkLogin(request, response);
		int id_libro = Integer.parseInt(request.getParameter("libro"));
		String email = (String) request.getSession().getAttribute("email");
		request.setAttribute("prenotato", libDAO.prenota(id_libro, email));
		RequestDispatcher d = request.getRequestDispatcher("./VIEW/Ricerca.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
