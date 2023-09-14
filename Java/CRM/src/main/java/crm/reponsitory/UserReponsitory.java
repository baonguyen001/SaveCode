package crm.reponsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm.config.MysqlConnection;
import crm.model.User;

//package crm.reponsitory : Có nhiệm vụ chứa các file reponsitory 
//Thực hiện câu query lấy dữ liệu từ database (Không có logic code)
public class UserReponsitory {
	// Thực hiện các câu query liên quan tới bảng Users

	// Tạo hàm lấy username và password từ bảng user
	public List<User> getUserByUsernameAndPassword(String username, String password) {
		List<User> list = new ArrayList<User>();

		// Mở kết nối Mysql
		Connection connection = MysqlConnection.getConnection();
		// "select * from users u where u.username = \"nguyenvana\" and u.password =
		// \"123456\"". ? kí hiệu tham số truyền vào
		String query = "select * from users u where u.username = ? and u.password = ? ";

		try {
			// Chuẩn bị câu query "select * from users u where u.username = ? and u.password = ? "
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			// Và Truyền tham số
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			// Thực thi câu query
			//executeQuery() Chỉ sử dụng cho câu select 
			//executeUpdate() sử dụng cho câu insert, delete...
			ResultSet resultSet = preparedStatement.executeQuery();
			// Khi resultSet còn giá trị thì tiếp tục thực hiện
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setFullname(resultSet.getString("fullname"));
				user.setAge(resultSet.getInt("age"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setCreate_date(resultSet.getString("create_date"));
				list.add(user);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//Đóng kết nối
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
