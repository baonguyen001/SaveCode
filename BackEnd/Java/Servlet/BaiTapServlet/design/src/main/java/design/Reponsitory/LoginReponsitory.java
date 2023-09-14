package design.Reponsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import design.Config.MysqlConnection;
import design.Model.Users;

public class LoginReponsitory {
	
	public List<Users> getUsersByAccoutAndPassword(String accout, String password){
		List<Users> list = new ArrayList();
		//Mo ket noi Mysql
		Connection connection = MysqlConnection.getConnection();
		
		//Chuan bi cau query
		String query = "select * from users u where u.accout = ? and u.password = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, accout);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Users users = new Users();
				users.setId(resultSet.getInt("id"));
				users.setName(resultSet.getString("name"));
				users.setAccout(resultSet.getString("account"));
				users.setPassword(resultSet.getString("password"));
				list.add(users);
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
	
	
	
	
	
}
