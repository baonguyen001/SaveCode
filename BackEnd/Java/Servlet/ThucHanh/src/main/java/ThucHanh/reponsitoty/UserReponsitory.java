package ThucHanh.reponsitoty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ThucHanh.Config.MysqlConnection;
import ThucHanh.Model.User;

//Chỉ thực hiện các câu query
public class UserReponsitory {
	//Tạo hàm lấy dữ liệu từ bảng user
	public List<User> getUserByUserNameAndPassword(String username, String password){
		List<User> list = new ArrayList<User>();
		
		//Mở kết nối Mysql
		Connection connection = MysqlConnection.getConnection();
		String query = "select * from users u where u.username = ? and u.password = ? ";
		
		try {
			//Chuẩn bị và truyền tham số cho câu query
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			//Thực thi câu query
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setAge(resultSet.getInt("age"));
				user.setFullname(resultSet.getString("fullname"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setCreate_date(resultSet.getString("create_date"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
