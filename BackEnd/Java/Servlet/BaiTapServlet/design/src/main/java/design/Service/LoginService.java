package design.Service;

import java.util.List;

import design.Model.Users;
import design.Reponsitory.LoginReponsitory;

public class LoginService {
	
	private LoginReponsitory login = new LoginReponsitory();
	
	public boolean checkLogin(String accout, String password){
		List<Users> list = login.getUsersByAccoutAndPassword(accout, password);
		return list.size() > 0;
	}
}
