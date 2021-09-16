package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Admin;
import entity.Phim;

public class AdminDAO {
	public Admin checkLoginDAO(Admin a) {
		try {
			String sql = "select `id`,`account`,`email` from `admin` where `account`= ? and `password`=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, a.getAccount());
			sta.setString(2, a.getPassword());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new Admin(rs.getLong(1), rs.getString(2), "0", rs.getString(3));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void editDAO(Phim p) {
		String sql = "update phim set `type`=? , `category`=? , episode=? , episodeURL=? , imageURL=? , title=? where id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, p.getType());
			sta.setString(2, p.getCategory());
			sta.setString(3, p.getEpisode());
			sta.setString(4, p.getEpisodeURL());
			sta.setString(5, p.getImageURL());
			sta.setString(6, p.getTitle());
			sta.setLong(7, p.getId());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removePhimDAO(long id) {
		String sql = "delete from phim where id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, id);
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeCommentDAO(long id) {
		String sql = "delete from phim where phim_id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, id);
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeResponseDAO(long id) {
		String sql = "delete from phim where phim_id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, id);
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDAO(Phim p) {
		String sql = "insert into phim(`type`,`category`,`episode`,`episodeURL`,`imageURL`,`title`) values(?,?,?,?,?,?)";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, p.getType());
			sta.setString(2, p.getCategory());
			sta.setString(3, p.getEpisode());
			sta.setString(4, p.getEpisodeURL());
			sta.setString(5, p.getImageURL());
			sta.setString(6, p.getTitle());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateEmailDAO(Admin a) {
		String sql = "update `admin`set `email`=? where id=? and `password`=?;";
		int rs = 0;
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, a.getEmail());
			sta.setLong(2, a.getId());
			sta.setString(3, a.getPassword());
			rs = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rs != 0) {
			return true;
		}
		return false;
	}

	public Admin checkPasswordDAO(Admin a) {
		try {
			String sql = "select `id`,`account`,`email` from `admin` where `password`= ? and `id`=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, a.getPassword());
			sta.setLong(2, a.getId());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new Admin(rs.getLong(1), rs.getString(2), "0", rs.getString(3));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePasswordDAO(Admin a) {
		String sql = "update `admin`set `password`=? where id=? and `password` =?;";
		int rs = 0;
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, a.getAccount());
			sta.setLong(2, a.getId());
			sta.setString(3, a.getPassword());
			rs = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Admin checkAccountDAO(String account) {
		try {
			String sql = "select `email`,`account` from `admin` where `account`= ?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, account);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new Admin(1, rs.getString(2), null, rs.getString(1));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePassword1DAO(Admin a) {
		String sql = "update `admin` set `password`=? where `account` =?;";

		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, a.getPassword());
			sta.setString(2, a.getAccount());
			int rs = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Phim> getReport() {
		List<Phim> list = new ArrayList<>();
		try {
			String sql = "select * from phim where `report`=? order by(id) desc;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "1");
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9),0));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void reportDAO(String id) {
		String sql = "update phim set `report`=? where id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, 0);
			sta.setString(2, id);
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
