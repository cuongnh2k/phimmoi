package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;
import dao.UserDAO;
import entity.History;
import entity.Phim;
import entity.User;

@WebServlet("/detail")
public class UserDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		long id = Long.parseLong(req.getParameter("id"));

		req.setAttribute("categoryPhimLe", new UserDAO().getCategoryPhimLe());
		req.setAttribute("categoryPhimBo", new UserDAO().getCategoryPhimBo());
		req.setAttribute("categoryPhimChieuRap", new UserDAO().getCategoryPhimChieuRap());
		req.setAttribute("categoryPhimHoatHinh", new UserDAO().getCategoryPhimHoatHinh());
		Phim p = new UserDAO().getPhim(id);
		if (p.getType().equals("Phim bộ") || p.getType().equals("Phim hoạt hình")) {
			req.setAttribute("boPhim", new UserDAO().getBoPhim(p));
		}
		req.setAttribute("phim", p);
		req.setAttribute("phimTuongTu", new UserDAO().getPhimTuongTu(p));
		req.setAttribute("report", new AdminDAO().getReport());

		req.setAttribute("comment", new UserDAO().getComment(id));
		req.setAttribute("response", new UserDAO().getResponse(id));

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<History> list = new ArrayList<History>();
		if (user != null) {

			User u = new UserDAO().checkUser(user);
			Calendar cal = Calendar.getInstance();
			String time = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND) + " - "
					+ cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/"
					+ cal.get(Calendar.YEAR);
			u.setHistory(u.getHistory() + "$" + p.getId() + "#" + p.getTitle() + "#" + time);
			String arr[] = u.getHistory().split("\\$");
			for (int i = 0; i < arr.length; i++) {
				try {
					String arr1[] = arr[i].split("\\#");
					list.add(new History(Long.parseLong(arr1[0]), arr1[1], arr1[2]));
				} catch (NumberFormatException e) {
					continue;
				}
			}

			if (list.size() > 1000) {
				for (int i = 0; i < list.size() - 1000; i++) {
					list.remove(i);
					i--;
				}
			}
			u.setHistory(" # # $ # # ");
			for (int i = 0; i < list.size(); i++) {
				History history = (History) list.get(i);
				u.setHistory(
						u.getHistory() + "$" + history.getId() + "#" + history.getTitle() + "#" + history.getTime());
			}
			new UserDAO().updateHistory(u);
		}
		Collections.reverse(list);
		req.setAttribute("history", list);
		req.getRequestDispatcher("WatchMovie.jsp").forward(req, resp);
	}
}
