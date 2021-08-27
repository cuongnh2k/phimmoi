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

@WebServlet("/check-password")
public class CheckPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		Admin a = new Admin(Integer.parseInt(req.getParameter("id")), null, req.getParameter("pass"), null);
		PrintWriter out = resp.getWriter();
		if (new AdminDAO().checkPasswordDAO(a) != null) {
			out.println("<i class=\"bi bi-check-circle text-success  \"></i>");
		} else {
			out.println("<i class=\"bi bi-x-circle text-danger\"></i>");
		}

	}
}
