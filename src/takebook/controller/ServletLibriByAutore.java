package takebook.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import takebook.checkLogin.CheckLogin;
import takebook.model.Libro;
import takebook.model.DAO.AutoreDAO;
import takebook.model.DAO.impl.AutoreDAOimpl;

/**
 * Servlet implementation class ServletLibriByAutore
 */

@WebServlet("/ServletLibriByAutore")
public class ServletLibriByAutore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AutoreDAO autDAO;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ServletLibriByAutore() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException{
    	ServletLibriByAutore.autDAO = new AutoreDAOimpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckLogin.checkLogin(request, response);
		int id_autore = Integer.parseInt(request.getParameter("autore"));
		ArrayList<Libro> listaLibri =  autDAO.getLibriByAutore(id_autore);
		request.setAttribute("listaLibri", listaLibri);
		RequestDispatcher rd = request.getRequestDispatcher("./VIEW/Ricerca.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
