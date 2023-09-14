package ThucHanh.Services;

import java.util.List;

import ThucHanh.Model.User;
import ThucHanh.reponsitoty.UserReponsitory;

public class LoginServices {
	private UserReponsitory reponsitory = new UserReponsitory();
	
	
	//Xử lý logic code
		public boolean chekLogin(String username, String password) {
			List<User> list =  reponsitory.getUserByUserNameAndPassword(username, password);
			
			return list.size() > 0 ? true : false;
		}
}
