package hutubill.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static String username = "lyx";
	static String password = "1qaz@WSX";
	static String url = "jdbc:mysql://115.28.104.122:3306/test?" + "user=" + username + "&password=" + password
			+ "&useUnicode=true&characterEncoding=UTF8";
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url);
	}
}
