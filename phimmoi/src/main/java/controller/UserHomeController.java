package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;
import dao.UserDAO;
import entity.History;
import entity.Phim;
import entity.User;

@WebServlet("/home")
public class UserHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setAttribute("categoryPhimLe", new UserDAO().getCategoryPhimLe());
		req.setAttribute("categoryPhimBo", new UserDAO().getCategoryPhimBo());
		req.setAttribute("categoryPhimChieuRap", new UserDAO().getCategoryPhimChieuRap());
		req.setAttribute("categoryPhimHoatHinh", new UserDAO().getCategoryPhimHoatHinh());
		List<Phim> list1 = new ArrayList<Phim>();
		List<Phim> list2 = new ArrayList<Phim>();
		List<Phim> list3 = new ArrayList<Phim>();
		List<Phim> list4 = new UserDAO().getPhimDeCu();
		for (int i = 0; i < 4; i++) {
			list1.add(list4.get(i));
		}
		for (int i = 4; i < 8; i++) {
			list2.add(list4.get(i));
		}
		for (int i = 8; i < list4.size(); i++) {
			list3.add(list4.get(i));
		}
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		req.setAttribute("phimBoCapNhat", new UserDAO().getPhimBoCapNhat());
		req.setAttribute("phimLeCapNhat", new UserDAO().getPhimLeCapNhat());
		req.setAttribute("phimChieuRapCapNhat", new UserDAO().getPhimChieuRapCapNhat());
		req.setAttribute("phimHoatHinhCapNhat", new UserDAO().getPhimHoatHinhCapNhat());
		req.setAttribute("report", new AdminDAO().getReport());
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<History> list = new ArrayList<History>();
		if (user != null) {	
			
			User u=new UserDAO().checkUser(user);
			
			String arr[] = u.getHistory().split("\\$");
			for (int i = 0; i < arr.length; i++) {
				try {
					String arr1[] = arr[i].split("\\#");
					list.add(new History(Long.parseLong(arr1[0]), arr1[1], arr1[2]));
				} catch (NumberFormatException e) {
					continue;
				}
			}
		}
		Collections.reverse(list);
		req.setAttribute("history", list);
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}
}