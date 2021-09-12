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
import entity.User;

@WebServlet("/update-comment")
public class UserUpdateCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		Comment comment = new Comment(Long.parseLong(req.getParameter("id")), req.getParameter("content"),
				Long.parseLong(req.getParameter("user-id")), null, null, Long.parseLong(req.getParameter("phim-id")),
				false);

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user.getId() == comment.getUser_id()) {
			new UserDAO().updateComment(comment);
			resp.sendRedirect("detail?id=" + comment.getPhim_id());

		} else {
			resp.sendRedirect("detail?id=" + comment.getPhim_id());
		}
	}

}
