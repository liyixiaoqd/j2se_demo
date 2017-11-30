package hutubill.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hutubill.entity.Category;
import hutubill.util.DBUtil;

public class CategoryDao extends Dao {
	public void add(Category category) {
		try {
			c = DBUtil.getConnection();

			String sql = "insert into category values(null,?)";
			ps = c.prepareStatement(sql);
			ps.setString(1, category.name);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				category.id = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
	}

	public void delete(Category category) {
		try {
			c = DBUtil.getConnection();
			String sql = "delete from category where id = " + category.id;
			s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
	}

	public void update(Category category) {
		try {
			c = DBUtil.getConnection();
			String sql = "update category set name=? where id = ?";
			ps = c.prepareStatement(sql);
			ps.setString(1, category.name);
			ps.setInt(3, category.id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
	}

	public Category getById(int id) {
		Category category = null;
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from category where id = " + id);
			if (rs.next()) {
				category = new Category();
				category.id = rs.getInt(1);
				category.name = rs.getString("name");
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		
		return category;
	}

	public int getTotal() {
		int total = 0;
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			ResultSet rs = s.executeQuery("select count(*) from category");
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

	public List<Category> list() {
		return list(0, Short.MAX_VALUE);
	}

	public List<Category> list(int start, int count) {
		List<Category> listC = new ArrayList<Category>();

		try {
			c = DBUtil.getConnection();
			String sql = "select * from category order by id desc limit ?,?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Category category = new Category();
				category.id = rs.getInt("id");
				category.name = rs.getString("name");
				listC.add(category);
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
}
