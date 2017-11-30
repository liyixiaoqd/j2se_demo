package object.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private List<Connection> cs = new ArrayList<Connection>();
	private int size;

	public ConnectionPool(int size) {
		this.size = size;

		// 这里恰恰不能使用try-with-resource的方式，因为这些连接都需要是"活"的，不要被自动关闭了
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for (int i = 0; i < this.size; i++) {
				Connection c = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
				cs.add(c);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized Connection getConnection(){
		while(cs.isEmpty()){
			try {
				System.out.println("等待线程池......");
				this.wait();
				System.out.println("被唤醒......");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cs.remove(0);
	}
	
	public synchronized void returnConnection(Connection c){
		cs.add(c);
		this.notifyAll();
	}
}
