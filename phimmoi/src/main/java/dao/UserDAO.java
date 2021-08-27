package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Phim;

public class UserDAO {

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
			String sql = "select * from phim group by(title) order by(sum(`view`)) desc limit 12;";
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
			String sql = "select * from phim where `type`=? group by(title) order by(id) desc limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "Phim lẻ");
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
			String sql = "select * from phim where `type`=? group by(title) order by(id) desc limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "Phim hoạt hình");
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
			String sql = "select * from phim where `type`=? group by(title) order by(id) desc limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "Phim chiếu rạp");
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
			String sql = "select * from phim where `type`=? group by(title) order by(id) desc limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "Phim bộ");
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
			setView(id);
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

	public List<Phim> getPhimTuongTu(Phim p) {
		List<Phim> list = new ArrayList<Phim>();
		try {
			String sql = "select * from phim where category=? group by(title) order by rand() limit 12;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, p.getCategory());
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

	public void setView(int id) {
		String sql = "update phim set `view`=`view`+1 where id=?;";
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

	public List<Phim> searchByName(String txt, int x) {
		List<Phim> list = new ArrayList<Phim>();
		try {
			String sql = "SELECT * FROM phim WHERE MATCH(title) AGAINST( ? ) group by(title) limit 12 offset ?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, txt);
			sta.setInt(2, x);
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

	public int searchByNameCount(String txt) {
		try {
			String sql = "select count(distinct title) FROM phim WHERE MATCH(title) AGAINST( ? );";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, txt);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Phim> searchMenu(Phim p) {
		List<Phim> list = new ArrayList<Phim>();
		try {
			String sql = "select * from phim where `type`=? and category=? group by(title) limit 12 offset ?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, p.getType());
			sta.setString(2, p.getCategory());
			sta.setLong(3, p.getView());
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

	public int searchMenuCount(Phim p) {
		try {
			String sql = "select count(distinct title) from phim where `type`=? and category=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, p.getType());
			sta.setString(2, p.getCategory());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
