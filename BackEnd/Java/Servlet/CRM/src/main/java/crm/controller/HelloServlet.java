package crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServelet", urlPatterns = { "/hello"})
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		System.out.println("Kiem Tra " + username);
		String password = req.getParameter("password");
		System.out.println("Pass " + password);
		
//		req.getRequestDispatcher("/login.jsp").forward(req, resp);
		resp.getWriter().append("Hello");
		
	}
}
