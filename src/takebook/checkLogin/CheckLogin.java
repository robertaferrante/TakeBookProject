package takebook.checkLogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLogin {
	
	/**CheckLogin impedisce l'accesso se il login non viene effettuato. Controlla per ogni jsp e servlet se 
	  la sessione è null. Se la sessione è null ritorna all'index per richiedere il logIn */
	
	public static void checkLogin(HttpServletRequest request,HttpServletResponse response) {
		if(request.getSession().getAttribute("nome") == null ){
			RequestDispatcher rd = request.getRequestDispatcher("./VIEW/index.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}				
		}	
	}
}
