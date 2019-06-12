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
		CheckLogin.checkLogin(request, response);

		String testo = request.getParameter("cerca");
		String ricerca = request.getParameter("ricerca");

	
		if(ricerca.equals("libro")) {
			ArrayList <Libro> listaLibri = (ArrayList<Libro>) libDAO.read(testo);
			request.setAttribute("listaLibri", listaLibri);
			if (listaLibri.size()==0) {
				request.setAttribute("notfound", "");

			}

		}
		if(ricerca.equals("autore")) {
			ArrayList <Libro> listaLibri = (ArrayList<Libro>) autDAO.getLibro(testo);
			request.setAttribute("listaLibri", listaLibri);
			if (listaLibri.size()==0) {
				request.setAttribute("notfound", "");

			}
		}
		if(ricerca.equals("categoria")) {
			ArrayList <Libro> listaLibri = (ArrayList<Libro>)  libDAO.getLibroByCategoria(testo);
			request.setAttribute("listaLibri", listaLibri);
			if (listaLibri.size()==0) {
				request.setAttribute("notfound", "");

			}
			
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
