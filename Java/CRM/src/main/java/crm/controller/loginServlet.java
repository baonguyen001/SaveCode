package crm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.service.LoginService;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet{
	
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		boolean isLogin = loginService.checkLogin(username, password);
		
		System.out.println(isLogin);
		
		
//		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123456"))
//		{
//			//Từ server trả về cho người dùng ta dùng resp.sendRedirect();
//			//Bị mất ContextPath CRM : http://localhost:8080/index.jsp
//			//req.getContextPath() sẽ thêm CRM vào đường dẫn
//			resp.sendRedirect(req.getContextPath() + "/index.jsp");
//		}else {
//			req.getRequestDispatcher("/login.jsp").forward(req, resp);
//		}
		
	}
}
