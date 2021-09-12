package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.Response;
import entity.User;

@WebServlet("/update-response")
public class UserUpdateResponseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		Response r = new Response(Long.parseLong(req.getParameter("id")), req.getParameter("content"),
				Long.parseLong(req.getParameter("user_id")), 0, null,
				null, Long.parseLong(req.getParameter("phim_id")), false);

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user.getId() == r.getUser_id()) {
			new UserDAO().updateResponse(r);
			resp.sendRedirect("detail?id=" + r.getPhim_id());

		} else {
			resp.sendRedirect("detail?id=" + r.getPhim_id());
		}
	}
}
