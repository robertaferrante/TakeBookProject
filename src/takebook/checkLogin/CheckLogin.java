package takebook.checkLogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLogin {
	

	
	public static void checkLogin(HttpServletRequest request,HttpServletResponse response) {

		if(request.getSession().getAttribute("nome") == null )
		{
		
			RequestDispatcher rd = request.getRequestDispatcher("./VIEW/index.jsp");
		
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			
		}

		
	}

}
