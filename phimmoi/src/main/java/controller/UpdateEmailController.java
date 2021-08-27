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

@WebServlet("/update-email")
public class UpdateEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		Admin a = (Admin) session.getAttribute("admin");
		if (a != null) {
			if (a.getAccount().equals("admin")) {

				Admin e = new Admin();
				e.setId(Integer.parseInt(req.getParameter("id")));
				e.setEmail(req.getParameter("email"));
				if (new AdminDAO().updateEmailDAO(e)) {
					a.setEmail(e.getEmail());
				}
				resp.sendRedirect("home");
			} else {
				resp.sendRedirect("login");
			}
		} else {
			resp.sendRedirect("login");
		}
	}
}
