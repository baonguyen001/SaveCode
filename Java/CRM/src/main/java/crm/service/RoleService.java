package crm.service;

import java.util.ArrayList;
import java.util.List;

import crm.model.Role;
import crm.reponsitory.RolesReponsitory;

public class RoleService {
	private RolesReponsitory reponsitory = new RolesReponsitory();
	
	public List<Role> getRole(){
		return reponsitory.getRole();
	}
	
	public boolean deleteRoleById(int id) {
		return reponsitory.deleteRoleById(id) > 0 ? true : false;
	}
	
	public boolean insertRole(String role_name, String description) {
		return reponsitory.insertRole(role_name, description) > 0;
	}
}
