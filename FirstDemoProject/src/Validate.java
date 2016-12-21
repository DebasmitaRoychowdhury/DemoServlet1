

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("name");
		
		String p=request.getParameter("pass");
		if(LoginDao.validate(n,p)){
			//response.sendRedirect("welcome.jsp");
			System.out.println("validation successful");
			//RequestDispatcher rd=request.getRequestDispatcher("/welcome.jsp");  
	        //rd.include(request,response);  
			Cookie ck=new Cookie("name",n);
			response.addCookie(ck);
			request.setAttribute("name",n);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);

	        
		}
		else{
																																																																																																																																																
			out.println("Invalid username or password!");																																																																								
			
			//response.sendRedirect("index.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
	        rd.include(request,response);  
		}
		
	}

}
