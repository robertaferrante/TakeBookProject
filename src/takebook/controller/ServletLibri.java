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
import takebook.model.DAO.LibroDAO;
import takebook.model.DAO.impl.LibroDAOimpl;

/**
 * Servlet implementation class ServletLibri
 */
@WebServlet("/ServletLibri")
public class ServletLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LibroDAO libDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ServletLibri() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException{
    	ServletLibri.libDAO = new LibroDAOimpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckLogin.checkLogin(request, response);
		ArrayList<Libro> listaLibri= libDAO.readAll();
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
