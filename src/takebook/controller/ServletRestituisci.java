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
 * Servlet implementation class ServletRestituisci
 */
@WebServlet("/ServletRestituisci")
public class ServletRestituisci extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LibroDAO libDAO;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRestituisci() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	ServletRestituisci.libDAO = new LibroDAOimpl();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckLogin.checkLogin(request, response);

		int id_libro = Integer.parseInt(request.getParameter("libro"));
		
		request.setAttribute("restituito", libDAO.restituito(id_libro));
		RequestDispatcher d = request.getRequestDispatcher("./VIEW/letueprenotazioni.jsp");
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
