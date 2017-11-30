package object.jdbc;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
	private static String username = "lyx";
	private static String password = "1qaz@WSX";
	private static String url = "jdbc:mysql://115.28.104.122:3306/test?" + "user=" + username + "&password=" + password
			+ "&useUnicode=true&characterEncoding=UTF8";

	public static Connection conn = null;
	public static Statement stat = null;

	public static void main(String args[]) throws UnsupportedEncodingException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载jdbc成功");

			conn = DriverManager.getConnection(url);
			System.out.println("连接成功,获取连接对象: " + conn);

			stat = conn.createStatement();
			System.out.println("获取statement对象: " + stat);
			
			String sql="insert into hero values(null,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "盖伦");
			ps.setFloat(2, 400f);
			ps.setFloat(3, 25f);
			ps.execute();
//			String sql = "insert into hero values(null," + "'赏金猎人'" + "," + 313.0f + "," + 50.f + ")";
//			
//			execute(sql);
			
//			String sql = "select * from hero";
//			ResultSet rs = stat.executeQuery(sql);
//			while(rs.next()){
//				System.out.print(rs.getInt(1) +"\t");
//				System.out.println(rs.getFloat("damage"));
//			}
//			rs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void execute(String sql) {
		if (sql == null)
			return;
		
		try {
			stat.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行SQL成功:"+sql);
	}
}
