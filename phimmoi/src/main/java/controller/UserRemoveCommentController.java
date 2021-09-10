package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.Comment;
import entity.Response;
import entity.User;

@WebServlet("/remove-comment")
public class UserRemoveCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		Comment comment = new Comment(Integer.parseInt(req.getParameter("id")), null,
				Long.parseLong(req.getParameter("user_id")), null, null, Integer.parseInt(req.getParameter("phim_id")));

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user.getId() == comment.getUser_id()) {
			new UserDAO().deleteResponse(comment);
			new UserDAO().deleteComment(comment);
			resp.sendRedirect("detail?id=" + comment.getPhim_id());

		} else {
			resp.sendRedirect("detail?id=" + comment.getPhim_id());
		}
	}
}
