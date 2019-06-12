package takebook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import takebook.checkLogin.CheckLogin;
import takebook.model.Libro;
import takebook.model.DAO.LibroDAO;
import takebook.model.DAO.impl.LibroDAOimpl;

/**
 * Servlet implementation class ServletLetueprenotazioni
 */
@WebServlet("/ServletLetueprenotazioni")
public class ServletLetueprenotazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LibroDAO libDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ServletLetueprenotazioni() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException{
    	ServletLetueprenotazioni.libDAO = new LibroDAOimpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckLogin.checkLogin(request, response);
		String email = (String) request.getSession().getAttribute("email");
		List<Libro> l = libDAO.getPrenotati(email);
		request.setAttribute("prenotazioni", l);
		RequestDispatcher rd = request.getRequestDispatcher("./VIEW/letueprenotazioni.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
