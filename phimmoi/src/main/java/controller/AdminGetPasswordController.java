package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import entity.Admin;
import service.Service;

@WebServlet("/get-password")
public class AdminGetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.getRequestDispatcher("GetPassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String account=req.getParameter("account");
		Admin a1 = new AdminDAO().checkAccountDAO(account);
		
		if (a1 != null) {
			a1.setPassword(new Service().random());
			new AdminDAO().updatePassword1DAO(a1);
			new Service().senPassword(a1.getEmail(), a1.getPassword());
			req.setAttribute("loi", "Một email chứa mật khẩu đã được gửi đến email của bạn");
			req.getRequestDispatcher("GetPassword.jsp").forward(req, resp);
		} else {
			req.setAttribute("loi", "Tài khoản không chính xác");
			req.getRequestDispatcher("GetPassword.jsp").forward(req, resp);
		}
	}
}
