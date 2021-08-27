package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import entity.Admin;
import entity.Phim;

public class AdminDAO {
	public Admin checkLoginDAO(Admin a) {
		try {
			String sql = "select * from `admin` where `account`= ? and `password`=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, a.getAccount());
			sta.setString(2, a.getPassword());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
			sta.setInt(7, p.getId());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeDAO(int id) {
		String sql = "delete from phim where id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, id);
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
		String sql = "update `admin`set `email`=? where id=?;";
		int rs = 0;
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, a.getEmail());
			sta.setInt(2, a.getId());
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
			String sql = "select * from `admin` where `password`= ? and `id`=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, a.getPassword());
			sta.setInt(2, a.getId());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
