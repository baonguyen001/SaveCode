package ThucHanh.Api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ThucHanh.Services.RoleService;
import ThucHanh.common.Constant;
import ThucHanh.payload.ReponData;

@WebServlet(name = "roleApi", urlPatterns = {Constant.URL_ROLE_API_DELETE, Constant.URL_ROLE_API_ADD})
public class RoleAPI extends HttpServlet {
	private RoleService roleService = new RoleService();
	private Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Lấy đường dẫn từ clien
		String urlPath = req.getServletPath();	
		
		switch(urlPath) {
		case Constant.URL_ROLE_API_DELETE:
			deleteRole(req, resp);
			break;
			
		case Constant.URL_ROLE_API_ADD:
			insertRole(req, resp);
			break;
		}
		
		
		
	}
	
	private void deleteRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//Trich xuat tham so id tu yeu cau http
				int id = Integer.parseInt(req.getParameter("id")) ;
				
				boolean isSucces = roleService.deleteRoleById(id);
				
				/*Biến class ResponData thành chuỗi Json
				{
					isSuccess: true,
					data:{
					},
					description: ""
				}
				*/
				ReponData data = new ReponData();
				data.setSucces(isSucces);
				data.setData("");
				data.setDescription("");
				
				String json = gson.toJson(data);
				
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				
				PrintWriter printWriter = resp.getWriter();
				printWriter.print(json);
				printWriter.flush();
				
	}
	
	private void insertRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//Trich xuat tham so id tu yeu cau http
		String  name = req.getParameter("name");
		String decs = req.getParameter("decs");
		
		boolean isSucces = roleService.insertRole(name, decs);
		
		/*Biến class ResponData thành chuỗi Json
		{
			isSuccess: true,
			data:{
			},
			description: ""
		}
		*/
		ReponData data = new ReponData();
		data.setSucces(isSucces);
		data.setData("");
		data.setDescription("");
		
		String json = gson.toJson(data);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(json);
		printWriter.flush();
	}
}
