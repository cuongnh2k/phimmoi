package stackjava.com.accessfacebook.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restfb.types.User;

import dao.UserDAO;
import stackjava.com.accessfacebook.common.RestFB;

@WebServlet("/login-facebook")
public class LoginFacebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginFacebookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");

		if (code == null || code.isEmpty()) {
			RequestDispatcher dis = request.getRequestDispatcher("home");
			dis.forward(request, response);
		} else {
			String accessToken = RestFB.getToken(code);
			User user = RestFB.getUserInfo(accessToken);

//			request.setAttribute("id", user.getId());
//			request.setAttribute("name", user.getName());
//			request.getRequestDispatcher("index.jsp").forward(request, response);

			entity.User u = new entity.User(Long.parseLong(user.getId()), user.getName());
			entity.User u1 = new UserDAO().checkUser(u);
			if (u1 != null) {
				if (!u1.getName().equalsIgnoreCase(u.getName())) {
					new UserDAO().updateName(u);
				}
				HttpSession session = request.getSession();
				session.setAttribute("user", u);
				response.sendRedirect("home");
			} else {
				new UserDAO().addUser(u);
				HttpSession session = request.getSession();
				session.setAttribute("user", u);
				response.sendRedirect("home");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
