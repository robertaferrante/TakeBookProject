package takebook.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import takebook.model.DAO.AutoreDAO;
import takebook.model.DAO.LibroDAO;
import takebook.model.DAO.impl.AutoreDAOimpl;
import takebook.model.DAO.impl.LibroDAOimpl;

/**
 * Servlet implementation class ServletRicerca
 */
@WebServlet("/ServletRicerca")
public class ServletRicerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LibroDAO libDAO;
	private static AutoreDAO autDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRicerca() {
        super();
    }

    public void init(ServletConfig config) throws ServletException{
    	ServletRicerca.libDAO = new LibroDAOimpl();
    	ServletRicerca.autDAO = new AutoreDAOimpl();

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testo = request.getParameter("cerca");
		String ricerca = request.getParameter("ricerca");
		
		if(ricerca.equals("libro")) {
			request.setAttribute("listaLibri", libDAO.read(testo));

		}
		if(ricerca.equals("autore")) {
			request.setAttribute("listaLibri", autDAO.getLibro(testo));
			
		}
		RequestDispatcher d = request.getRequestDispatcher("./VIEW/Ricerca.jsp");
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
