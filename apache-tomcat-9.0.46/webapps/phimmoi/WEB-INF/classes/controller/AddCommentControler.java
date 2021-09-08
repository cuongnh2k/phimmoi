package controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.Comment;
import entity.User;

@WebServlet("/add-comment")
public class AddCommentControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		Calendar calendar = Calendar.getInstance();
		String time = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.HOUR) + ":"
				+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);

		Comment comment = new Comment(0, req.getParameter("text"), Long.parseLong(req.getParameter("user-id")), time,
				null, Integer.parseInt(req.getParameter("phim-id")));

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			new UserDAO().addComment(comment);
			resp.sendRedirect("detail?id=" + comment.getPhim_id());

		} else {
			resp.sendRedirect("detail?id=" + comment.getPhim_id());
		}
	}
}