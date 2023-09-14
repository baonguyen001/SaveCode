package ThucHanh.Services;

import java.util.List;

import ThucHanh.Model.Role;
import ThucHanh.reponsitoty.RoleReponsitory;

public class RoleService {
	private RoleReponsitory reponsitory = new RoleReponsitory();
	
	public List<Role> getRole(){
		return reponsitory.getRoles();
	}
	
	public boolean deleteRoleById(int id) {
		return reponsitory.deleteRoleById(id) > 0 ? true : false;
	}
	
	public boolean insertRole(String name, String decs) {
		return reponsitory.insertRole(name, decs) > 0;
	}
}
