package crm.service;

import java.util.List;

import crm.model.User;
import crm.reponsitory.UserReponsitory;

//package crm.service chứa các class liên quan đến xử lý logic code 
public class LoginService {

	private UserReponsitory userReponsitory = new UserReponsitory();

	// Kiếm tra login
	// Nhận 2 tham số username và password từ loginServlet để kiểm tra
	public boolean checkLogin(String username, String password) {
		List<User> list = userReponsitory.getUserByUsernameAndPassword(username, password);

		return list.size() > 0 ?true :false;
	

	}

}
