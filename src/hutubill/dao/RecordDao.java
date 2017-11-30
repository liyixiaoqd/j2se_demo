package hutubill.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hutubill.entity.Record;
import hutubill.util.DBUtil;
import hutubill.util.DateUtil;

public class RecordDao extends Dao{
	public void add(Record record) {
		try {
			c = DBUtil.getConnection();

			String sql = "insert into record values(null,?,?,?,?)";
			ps = c.prepareStatement(sql);
			ps.setInt(2, record.spend);
			ps.setInt(3, record.cid);
			ps.setString(4, record.comment);
			ps.setDate(5, DateUtil.utils2sql(record.date));
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				record.id = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
	}

	public void delete(Record record) {
		try {
			c = DBUtil.getConnection();
			String sql = "delete from record where id = " + record.id;
			s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
	}

	public void update(Record record) {
		try {
			c = DBUtil.getConnection();
			String sql = "update record set spend=?,cid=?,comment=?,date=? where id = ?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, record.spend);
			ps.setInt(2, record.cid);
			ps.setString(3, record.comment);
			ps.setDate(4, DateUtil.utils2sql(record.date));
			ps.setInt(5, record.id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
	}

	public Record getById(int id) {
		Record record = null;
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from record where id = " + id);
			if (rs.next()) {
				record = new Record();
				record.id = rs.getInt(1);
				record.spend = rs.getInt("spend");
				record.cid = rs.getInt("cid");
				record.comment = rs.getString("comment");
				record.date = rs.getDate("date");
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		
		return record;
	}

	public int getTotal() {
		int total = 0;
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			ResultSet rs = s.executeQuery("select count(*) from record");
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

	public List<Record> list() {
		return list(0, Short.MAX_VALUE);
	}

	public List<Record> list(int start, int count) {
		List<Record> listC = new ArrayList<Record>();

		try {
			c = DBUtil.getConnection();
			String sql = "select * from record order by id desc limit ?,?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Record record = new Record();
				record.id = rs.getInt(1);
				record.spend = rs.getInt("spend");
				record.cid = rs.getInt("cid");
				record.comment = rs.getString("comment");
				record.date = rs.getDate("date");
				listC.add(record);
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
	
	/**
	 * 某消费类型
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Record> list(int cid) {
		List<Record> listC = new ArrayList<Record>();

		try {
			c = DBUtil.getConnection();
			String sql = "select * from record where cid=? order by id desc";
			ps = c.prepareStatement(sql);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Record record = new Record();
				record.id = rs.getInt(1);
				record.spend = rs.getInt("spend");
				record.cid = rs.getInt("cid");
				record.comment = rs.getString("comment");
				record.date = rs.getDate("date");
				listC.add(record);
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

	/**
	 * 当天
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Record> listToday() {
		return list(DateUtil.today());
	}
	
	
	/**
	 * 某天
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Record> list(Date day) {
		return list(day,day);
	}
	
	/**
	 * 时间范围内
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Record> list(Date start, Date end) {
		List<Record> listC = new ArrayList<Record>();

		try {
			c = DBUtil.getConnection();
			String sql = "select * from record where date>=? and date<=? order by id desc";
			ps = c.prepareStatement(sql);
			ps.setDate(1, DateUtil.utils2sql(start));
			ps.setDate(2, DateUtil.utils2sql(end));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Record record = new Record();
				record.id = rs.getInt(1);
				record.spend = rs.getInt("spend");
				record.cid = rs.getInt("cid");
				record.comment = rs.getString("comment");
				record.date = rs.getDate("date");
				listC.add(record);
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
