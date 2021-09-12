package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Comment;
import entity.Phim;
import entity.Response;
import entity.User;

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
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9)));
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
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9)));
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
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9)));
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
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9)));
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
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Phim getPhim(long id) {
		try {
			String sql = "select * from phim where id=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, id);
			ResultSet rs = sta.executeQuery();
			setView(id);
			while (rs.next()) {
				return new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9));
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
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9)));
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
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void setView(long id) {
		String sql = "update phim set `view`=`view`+1 where id=?;";
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

	public List<Phim> searchByName(String txt, long x) {
		List<Phim> list = new ArrayList<Phim>();
		try {
			String sql = "SELECT * FROM phim WHERE MATCH(title) AGAINST( ? ) group by(title) limit 12 offset ?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, txt);
			sta.setLong(2, x);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public long searchByNameCount(String txt) {
		try {
			String sql = "select count(distinct title) FROM phim WHERE MATCH(title) AGAINST( ? );";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, txt);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return rs.getLong(1);
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
				list.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getLong(8), rs.getBoolean(9)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public long searchMenuCount(Phim p) {
		try {
			String sql = "select count(distinct title) from phim where `type`=? and category=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, p.getType());
			sta.setString(2, p.getCategory());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return rs.getLong(1);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void reportDAO(String id) {
		String sql = "update phim set `report`=? where id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, 1);
			sta.setString(2, id);
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Comment> getComment(long id) {
		List<Comment> list = new ArrayList<Comment>();
		try {
			String sql = "select `comment`.id, `comment`.content,`comment`.user_id,`comment`.`time`, `user`.`name`,`comment`.edit from `user`, `comment` where `user`.id=`comment`.user_id and `comment`.phim_id=? order by (`comment`.id) desc;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, id);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Comment(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), id,
						rs.getBoolean(6)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Response> getResponse(long id) {
		List<Response> list = new ArrayList<>();
		try {
			String sql = "select `response`.id, `response`.content,`response`.user_id,`response`.`comment_id`, `response`.`time`,`user`.`name`,`response`.`edit` from `user`, `response` where `user`.id=`response`.user_id and `response`.phim_id=? order by (`response`.id) desc;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, id);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Response(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getLong(4), rs.getString(5),
						rs.getString(6), id, rs.getBoolean(7)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public User checkUser(User u) {
		try {
			String sql = "select * from `user` where id=?;";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setObject(1, u.getId());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new User(rs.getLong(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addUser(User u) {
		String sql = "insert into `user` values(?,?,?);";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, u.getId());
			sta.setString(2, u.getName());
			sta.setString(3, u.getHistory());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateName(User u) {
		String sql = "update `user` set `name`=? where id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(2, u.getId());
			sta.setString(1, u.getName());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addComment(Comment cmt) {
		String sql = "insert into `comment`(`content`,`user_id`,`phim_id`,`time`) values(?,?,?, CURRENT_TIMESTAMP() );";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, cmt.getContent());
			sta.setLong(2, cmt.getUser_id());
			sta.setLong(3, cmt.getPhim_id());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addResponse(Response res) {
		String sql = "insert into `response`(`content`,`user_id`,`comment_id`,`phim_id`,`time`) values(?,?,?,?, CURRENT_TIMESTAMP() );";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, res.getContent());
			sta.setLong(2, res.getUser_id());
			sta.setLong(3, res.getComment_id());
			sta.setLong(4, res.getPhim_id());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteComment(Comment cmt) {
		String sql = "delete from `comment` where `id`=? and user_id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(2, cmt.getUser_id());
			sta.setLong(1, cmt.getId());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteResponse(Comment cmt) {
		String sql = "delete from `response` where `comment_id`=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, cmt.getId());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateComment(Comment cmt) {
		String sql = "update `comment` set `content`=? , `time`= CURRENT_TIMESTAMP(), `edit`=1 where `id`=? and user_id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, cmt.getContent());
			sta.setLong(2, cmt.getId());
			sta.setLong(3, cmt.getUser_id());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void updateResponse(Response cmt) {
		String sql = "update `response` set `content`=? , `time`= CURRENT_TIMESTAMP(), `edit`=1 where `id`=? and user_id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, cmt.getContent());
			sta.setLong(2, cmt.getId());
			sta.setLong(3, cmt.getUser_id());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeResponse(Response cmt) {
		String sql = "delete from `response` where `id`=? and user_id=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setLong(1, cmt.getId());
			sta.setLong(2, cmt.getUser_id());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateHistory(User u) {
		String sql = "update `user` set `history`= ? where `id`=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, u.getHistory());
			sta.setLong(2, u.getId());
			int rs2 = sta.executeUpdate();
			sta.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
