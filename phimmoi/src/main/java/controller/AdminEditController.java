package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;
import entity.Admin;
import entity.Phim;

@WebServlet("/edit")
public class AdminEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		Admin a = (Admin) session.getAttribute("admin");
		if (a != null) {

			Phim p = new Phim(Long.parseLong(req.getParameter("id")), req.getParameter("type"),
					req.getParameter("category"), req.getParameter("episode"), req.getParameter("episodeURL"),
					req.getParameter("imageURL"), req.getParameter("title"), 0, false);
			new AdminDAO().editDAO(p);
			resp.sendRedirect("detail?id=" + p.getId());
		} else {
			resp.sendRedirect("login");
		}
	}
}
