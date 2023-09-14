package ThucHanh.reponsitoty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ThucHanh.Config.MysqlConnection;
import ThucHanh.Model.Role;

public class RoleReponsitory {
	
	
	public List<Role> getRoles(){
		List<Role> list = new ArrayList<Role>();
		//Mở kết nối
		Connection connection = MysqlConnection.getConnection();
		String query = "select * from roles";
		
		
		try {
			//Chuan bi cau query
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			//Thuc thi cau query
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setRole_name(resultSet.getString("role_name"));
				role.setDescription(resultSet.getString("description"));
				
				list.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public int deleteRoleById(int id) {
		Connection connection = MysqlConnection.getConnection();
		String query = "delete from roles r where r.id = ?";
		int isDelete = 0;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			isDelete = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return isDelete;
		
	}
	
	public int insertRole(String name, String decs) {
		Connection connection = MysqlConnection.getConnection();
		String query = "delete from roles r where r.id = ?";
		int isSucces = 0;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, decs);
			
			isSucces = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return isSucces;
	}
	
}
