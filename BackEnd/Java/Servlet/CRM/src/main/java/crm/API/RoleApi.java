package crm.API;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm.common.Constant;
import crm.payload.ResponData;
import crm.service.RoleService;

@WebServlet(name = "roleApi", urlPatterns = { Constant.URL_ROLE_API_DELETE, Constant.URL_ROLE_API_ADD })
public class RoleApi extends HttpServlet {

	private RoleService roleService = new RoleService();
	private Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String urlPath = req.getServletPath();

		switch (urlPath) {
		case Constant.URL_ROLE_API_DELETE:
			deleteRole(req, resp);
			
			break;
		case  Constant.URL_ROLE_API_ADD:
			addRole(req, resp);
			
			break;

		}

	}
	
	private void addRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// trích xuất tham số từ yêu cầu HTTP
		String roleName = req.getParameter("name");
		String decs = req.getParameter("decs");

		boolean isSucces = roleService.insertRole(roleName, decs);

		/*
		 * Biến class ResponData thành chuỗi Json { isSuccess: true, data:{ },
		 * description: "" }
		 */
		ResponData data = new ResponData();
		data.setSuccess(isSucces);
		data.setDescription("");
		data.setData("");

		// Biến data thành chuỗi json
		String json = gson.toJson(data);

		// "application/json" để chỉ định rằng phản hồi sẽ chứa dữ liệu được định dạng
		// dưới dạng JSON
		resp.setContentType("application/json");
		// Phương thức này đặt bộ mã hóa ký tự cho phản hồi
		resp.setCharacterEncoding("UTF-8");

		// Tạo một đối tượng PrintWriter để ghi dữ liệu phản hồi.
		PrintWriter printWriter = resp.getWriter();
		// Ghi chuỗi JSON vào PrintWriter.
		printWriter.print(json);
		// Đẩy dữ liệu ra phản hồi.
		printWriter.flush();
	}
	
	
	private void deleteRole (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// trích xuất tham số id từ yêu cầu HTTP
		int id = Integer.parseInt(req.getParameter("id"));

		boolean isSucces = roleService.deleteRoleById(id);

		/*
		 * Biến class ResponData thành chuỗi Json { isSuccess: true, data:{ },
		 * description: "" }
		 */
		ResponData data = new ResponData();
		data.setSuccess(isSucces);
		data.setDescription("");
		data.setData("");

		// Biến data thành chuỗi json
		String json = gson.toJson(data);

		// "application/json" để chỉ định rằng phản hồi sẽ chứa dữ liệu được định dạng
		// dưới dạng JSON
		resp.setContentType("application/json");
		// Phương thức này đặt bộ mã hóa ký tự cho phản hồi
		resp.setCharacterEncoding("UTF-8");

		// Tạo một đối tượng PrintWriter để ghi dữ liệu phản hồi.
		PrintWriter printWriter = resp.getWriter();
		// Ghi chuỗi JSON vào PrintWriter.
		printWriter.print(json);
		// Đẩy dữ liệu ra phản hồi.
		printWriter.flush();
	}

}
