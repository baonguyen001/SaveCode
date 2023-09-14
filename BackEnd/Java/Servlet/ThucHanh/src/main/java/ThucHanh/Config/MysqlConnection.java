package ThucHanh.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	//Tạo DataSource
	public static Connection getConnection() {
		Connection connection = null;
		try {
			//Điều này cho phép Java biết cách kết nối với cơ sở dữ liệu MySQL qua JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				//tạo kết nối thực sự tới cơ sở dữ liệu MySQL.
				//Phương thức này nhận vào URL kết nối của cơ sở dữ liệu 
				return DriverManager.getConnection("jdbc:mysql://localhost:3307/crm", "root", "admin123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
