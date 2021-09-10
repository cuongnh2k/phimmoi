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

@WebServlet("/login")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		Admin a = new AdminDAO()
				.checkLoginDAO(new Admin(0, req.getParameter("taiKhoan"), req.getParameter("matKhau"), null));
		if (a != null) {
			HttpSession session = req.getSession();
			session.setAttribute("admin", a);
			resp.sendRedirect("home");
		} else {
			req.setAttribute("loi", "Tài khoản hoặc mật khẩu không chính xác");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
	}
}
