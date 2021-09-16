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

@WebServlet("/add-response")
public class UserAddResponseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String content = req.getParameter("content");
		long phim_id = Long.parseLong(req.getParameter("phim_id"));
		content = content.replaceAll("  ", " ");
		content = content.trim();

		if (content.length() > 1) {
			Response r = new Response(0, content, Long.parseLong(req.getParameter("user_id")),
					Long.parseLong(req.getParameter("comment_id")), null, null,
					phim_id, false);

			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");

			if (user != null) {
				new UserDAO().addResponse(r);
				resp.sendRedirect("detail?id=" + r.getPhim_id());

			} else {
				resp.sendRedirect("detail?id=" + r.getPhim_id());
			}
		} else {
			resp.sendRedirect("detail?id=" + phim_id);
		}
	}

}
