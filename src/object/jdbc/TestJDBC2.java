package object.jdbc;

import java.sql.SQLException;

public class TestJDBC2 {
	public static void main(String args[]) {
		DBUtils dbu = DBUtils.getInstance();

		try {
			dbu.getConn().setAutoCommit(false);
			String sql1="update hero set hp=hp+1 where id=1";
			dbu.getStat().execute(sql1);
			System.out.println("update hp+1");
			String sql2="updat e hero set hp=hp-1 where id=1";
			dbu.getStat().execute(sql2);
			System.out.println("update hp-1");
			
			dbu.getConn().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
