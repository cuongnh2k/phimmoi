package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.Phim;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
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
		req.getRequestDispatcher("WatchMovie.jsp").forward(req, resp);
	}
}
