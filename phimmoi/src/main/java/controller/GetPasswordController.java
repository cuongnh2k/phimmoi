package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import entity.Admin;
import service.Service;

@WebServlet("/get-password")
public class GetPasswordController extends HttpServlet {
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
		Admin a = new Admin(0, req.getParameter("acc"), null, null);
		PrintWriter out = resp.getWriter();
		Admin a1 = new AdminDAO().checkAccountDAO(a);
		a1.setPassword(new Service().random());
		if (a1 != null) {
			Runnable task1 = () -> {
				out.println(
						"<sub class=\"text-success\">Chúng tôi đã gửi 1 email chứa mật khẩu tới tài khoản của bạn</sub>");
			};
			Runnable task2 = () -> {
				new AdminDAO().updatePassword1DAO(a1);
				new Service().senPassword(a1.getEmail(), a1.getPassword());
			};
			ExecutorService executorService = Executors.newFixedThreadPool(2);
			executorService.execute(task1);
			executorService.execute(task2);
			
			executorService.shutdown();
			
		} else {
			out.println("<sub>Tài khoản không chính xác</sub>");
		}
	}
}
