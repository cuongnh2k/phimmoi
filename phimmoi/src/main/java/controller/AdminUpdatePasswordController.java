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

@WebServlet("/update-password")
public class AdminUpdatePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		Admin a = (Admin) session.getAttribute("admin");
		if (a != null) {
			Admin e = new Admin();
			e.setId(Integer.parseInt(req.getParameter("id")));
			e.setPassword(req.getParameter("password"));
			e.setAccount(req.getParameter("newpass"));
			e.setEmail(req.getParameter("confirm"));
			if (e.getAccount().equals(e.getEmail())) {
				new AdminDAO().updatePasswordDAO(e);
			}
			resp.sendRedirect("home");

		} else {
			resp.sendRedirect("login");
		}
	}
}
