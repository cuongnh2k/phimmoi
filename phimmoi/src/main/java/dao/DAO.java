package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Phim;

public class DAO {

	public List<String> getCategoryPhimLe() {
		List<String> list = new ArrayList<>();
		try {
			String sql = "select distinct category from phim where `type`=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "Phim lẻ");
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getCategoryPhimBo() {
		List<String> list = new ArrayList<>();
		try {
			String sql = "select distinct category from phim where `type`=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "Phim bộ");
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getCategoryPhimChieuRap() {
		List<String> list = new ArrayList<>();
		try {
			String sql = "select distinct category from phim where `type`=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "Phim chiếu rạp");
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getCategoryPhimHoatHinh() {
		List<String> list = new ArrayList<>();
		try {
			String sql = "select distinct category from phim where `type`=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "Phim hoạt hình");
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Phim> getPhimDeCu() {
		List<Phim> list = new ArrayList<>();
		try {
			String sql = "select * from phim order by(`view`) desc limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Phim(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Phim> getPhimLeCapNhat() {
		List<Phim> list = new ArrayList<>();
		try {
			String sql = "select * from phim where `type`='Phim lẻ' order by(id) desc limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Phim(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Phim> getPhimHoatHinhCapNhat() {
		List<Phim> list = new ArrayList<>();
		try {
			String sql = "select * from phim where `type`='Phim hoạt hình'and episode = 1 or episode like '1 %' order by(id) desc limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Phim(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Phim> getPhimChieuRapCapNhat() {
		List<Phim> list = new ArrayList<>();
		try {
			String sql = "select * from phim where `type`='Phim chiếu rạp' order by(id) desc limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Phim(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Phim> getPhimBoCapNhat() {
		List<Phim> list = new ArrayList<>();
		try {
			String sql = "select * from phim where `type`='Phim bộ' and episode = 1 or episode like '1 %' order by(id) desc limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Phim(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Phim getPhim(int id) {
		try {
			String sql = "select * from phim where id=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, id);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new Phim(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Phim> getBoPhim(Phim p) {
		List<Phim> list = new ArrayList<Phim>();
		try {
			String sql = "select * from phim where title=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, p.getTitle());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Phim(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	public void plusCamera(Order o) {
//		String sql2 = "update camera set so_luong = so_luong+? where ma=? and the_loai=?;";
//		try {
//			Connection con2 = new DBContext().getConnection();
//			PreparedStatement sta2 = con2.prepareStatement(sql2);
//			sta2.setInt(1, o.getSoLuong());
//			sta2.setInt(2, o.getMaSP());
//			sta2.setInt(3, o.getTheLoai());
//			int rs2 = sta2.executeUpdate();
//			sta2.close();
//			con2.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
