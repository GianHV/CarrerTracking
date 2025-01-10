package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private final static String url = "jdbc:mysql://localhost:3306/carrertracking";
	private final static String username = "root";
	private final static String password = "Cong&Vien0504";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
