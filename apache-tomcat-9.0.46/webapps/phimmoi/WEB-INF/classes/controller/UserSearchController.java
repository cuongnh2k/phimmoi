package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.Phim;

@WebServlet("/search")
public class UserSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
	
		Phim p = new Phim();
		p.setType(req.getParameter("type"));
		p.setCategory(req.getParameter("category"));
		try {
			p.setView(Integer.parseInt(req.getParameter("index")));
		} catch (Exception e) {
			p.setView(0);
		}
		req.setAttribute("categoryPhimLe", new UserDAO().getCategoryPhimLe());
		req.setAttribute("categoryPhimBo", new UserDAO().getCategoryPhimBo());
		req.setAttribute("categoryPhimChieuRap", new UserDAO().getCategoryPhimChieuRap());
		req.setAttribute("categoryPhimHoatHinh", new UserDAO().getCategoryPhimHoatHinh());

		req.setAttribute("phimBoCapNhat", new UserDAO().getPhimBoCapNhat());
		req.setAttribute("phimLeCapNhat", new UserDAO().getPhimLeCapNhat());
		req.setAttribute("phimChieuRapCapNhat", new UserDAO().getPhimChieuRapCapNhat());
		req.setAttribute("phimHoatHinhCapNhat", new UserDAO().getPhimHoatHinhCapNhat());
		List<Phim> list5 = new UserDAO().searchMenu(p);
		req.setAttribute("searchMenu", list5);
		int a = new UserDAO().searchMenuCount(p);
		int b = a / 12;
		if (a % 12 != 0) {
			b += 1;
		}
		Map<Integer, Integer> list = new HashMap<Integer, Integer>();
		int index = 0;
		for (int i = 1; i <= b; i++) {
			list.put(i, index);
			index += 12;
		}
		Phim pp = list5.get(0);
		req.setAttribute("CT030408", pp);
		
			req.setAttribute("count", list);
		
		req.setAttribute("index", p.getView());
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}
}
