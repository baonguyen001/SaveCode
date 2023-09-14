package crm.reponsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm.config.MysqlConnection;
import crm.model.Role;

public class RolesReponsitory {
	//Tạo hàm lấy dữ liệu từ bảng roles
	public List<Role> getRole(){
		List<Role> list = new ArrayList<Role>();
		//Mở kết nối Mysql
		Connection connection = MysqlConnection.getConnection();
		String query = "select * from roles";
		
		//Chuẩn bị cho câu query
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			//Thực hiện câu query
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
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			//Truyền tham số
			preparedStatement.setInt(1, id);
			
			//Thực thi câu query. Nếu executeUpdate() xóa thành công sẽ trả về 1
			isDelete = preparedStatement.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDelete;
		
	}
	
	public int insertRole(String name, String desc){
		
		Connection connection = MysqlConnection.getConnection();
		String query = "insert into roles(role_name, description) value ( ?, ?)";
		int isSucces = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, desc);
			
			isSucces = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	return isSucces;
	}
	
}
