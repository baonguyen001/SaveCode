package ThucHanh.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ThucHanh.Services.LoginServices;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	
	private LoginServices login = new LoginServices();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		boolean isLogin = login.chekLogin(username, password);
		System.out.println(isLogin);
		
	}
}
