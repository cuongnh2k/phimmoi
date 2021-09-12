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

@WebServlet("/add")
public class AdminAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		Admin a = (Admin) session.getAttribute("admin");
		if (a != null) {

			Phim p = new Phim(0, req.getParameter("type"), req.getParameter("category"), req.getParameter("episode"),
					req.getParameter("episodeURL"), req.getParameter("imageURL"), req.getParameter("title"), 0, false,0);
			new AdminDAO().addDAO(p);
			resp.sendRedirect("home");
		} else {
			resp.sendRedirect("login");
		}
	}

}
