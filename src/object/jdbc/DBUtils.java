package object.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static String username = "lyx";
	private static String password = "1qaz@WSX";
	private static String url = "jdbc:mysql://115.28.104.122:3306/test?" + "user=" + username + "&password=" + password
			+ "&useUnicode=true&characterEncoding=UTF8";

	private Connection conn = null;
	private Statement stat = null;
	
	private static DBUtils dbu = new DBUtils();
	
	private DBUtils(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载jdbc成功");
			
			conn = DriverManager.getConnection(url);
			System.out.println("连接成功,获取连接对象: " + conn);
	
			stat = conn.createStatement();
			System.out.println("获取statement对象: " + stat);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DBUtils getInstance(){
		return dbu;
	}
	
	public Connection getConn(){
		return conn;
	}
	
	public Statement getStat(){
		return stat;
	}
}
