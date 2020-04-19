package test02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginMessage
 */
@WebServlet("/LoginMessage")
public class LoginMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String count = request.getParameter("count");
		Cookie cookie = new Cookie("username",username);
		cookie.setMaxAge(600);
		response.addCookie(cookie);
		cookie = new Cookie("password", password);
		cookie.setMaxAge(600);
		response.addCookie(cookie);
		if (count != null) {
			cookie.setMaxAge(0);
			response.sendRedirect("Login.jsp");
		}else {
			if (username.equals("changhuan") && password.equals("777777")) {
				request.getRequestDispatcher("LoginTrueView").forward(request, response);
			}else {
				response.sendRedirect("LoginErrorView");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
