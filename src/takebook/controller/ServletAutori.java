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
import takebook.model.Autore;
import takebook.model.DAO.AutoreDAO;
import takebook.model.DAO.impl.AutoreDAOimpl;

/**
 * Servlet implementation class ServletAutori
 */
@WebServlet("/ServletAutori")
public class ServletAutori extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AutoreDAO autDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutori() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	ServletAutori.autDAO = new AutoreDAOimpl();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckLogin.checkLogin(request, response);
		ArrayList<Autore> listaAutori = autDAO.readAll();
		request.setAttribute("listaAutori", listaAutori);
		
		RequestDispatcher rd = request.getRequestDispatcher("./VIEW/Autori.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
