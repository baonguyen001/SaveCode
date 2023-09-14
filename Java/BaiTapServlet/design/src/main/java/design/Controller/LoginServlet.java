package design.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import design.Service.LoginService;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	
	private LoginService loginService = new LoginService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/Welcom.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String accout = req.getParameter("accout");
		String password = req.getParameter("password");
		
		boolean isChecklogin = loginService.checkLogin(accout, password);
		
		if(accout.equals("admin") && password.equals("123456")) {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/indexFail.jsp").forward(req, resp);
		}
			
		
		
	}
}
