package hutubill.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hutubill.entity.Config;
import hutubill.util.DBUtil;

/***
 * CONFIG 实例与表进行ORM映射
 * 
 * @author Liyixiao
 *
 */
public class ConfigDao extends Dao{

	public void add(Config config) {
		try {
			c = DBUtil.getConnection();

			String sql = "insert into config values(null,?,?)";
			ps = c.prepareStatement(sql);
			ps.setString(1, config.key);
			ps.setString(2, config.values);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				config.id = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
	}

	public void delete(Config config) {
		try {
			c = DBUtil.getConnection();
			String sql = "delete from config where id = " + config.id;
			s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
	}

	public void update(Config config) {
		try {
			c = DBUtil.getConnection();
			String sql = "update config set key_=?,value=? where id = ?";
			ps = c.prepareStatement(sql);
			ps.setString(1, config.key);
			ps.setString(2, config.values);
			ps.setInt(3, config.id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
	}

	public Config getById(int id) {
		Config config = null;
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from config where id = " + id);
			if (rs.next()) {
				config = new Config();
				config.id = rs.getInt(1);
				config.key = rs.getString(2);
				config.values = rs.getString("value");
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}

		return config;
	}
	
	public Config getByKey(String key) {
		Config config = null;
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from config where key_ = '" + key+"'");
			if (rs.next()) {
				config = new Config();
				config.id = rs.getInt(1);
				config.key = rs.getString(2);
				config.values = rs.getString("value");
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}

		return config;
	}

	public int getTotal() {
		int total = 0;
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			ResultSet rs = s.executeQuery("select count(*) from config");
			if (rs.next()) {
				total = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return total;
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Config> list() {
		return list(0, Short.MAX_VALUE);
	}

	/**
	 * 分页查询
	 * 
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Config> list(int start, int count) {
		List<Config> listC = new ArrayList<Config>();

		try {
			c = DBUtil.getConnection();
			String sql = "select * from config order by id desc limit ?,?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Config config = new Config();
				config.id = rs.getInt("id");
				config.key = rs.getString("key_");
				config.values = rs.getString("value");
				listC.add(config);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}

		return listC;
	}


	public static void main(String args[]) {
		ConfigDao cd = new ConfigDao();
		Config config = cd.getByKey("test_k");

		System.out.println("add end and id:" + config.values);
		System.out.println("total:" + cd.getTotal());
		
		for(Config c:cd.list()){
			System.out.println(c.key);
		}
		
		cd.update(config);
	}
}
