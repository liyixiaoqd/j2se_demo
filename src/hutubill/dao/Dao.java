package hutubill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * 实例与表进行ORM映射
 * 
 * @author Liyixiao
 *
 */
public class Dao {
	protected Connection c = null;
	protected PreparedStatement ps = null;
	protected Statement s = null;
	

	/**
	 * 统一关闭函数
	 */
	protected void closeConnect() {
		try {
			if (ps != null)
				ps.close();
			if (s != null)
				s.close();
			if (c != null)
				c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
