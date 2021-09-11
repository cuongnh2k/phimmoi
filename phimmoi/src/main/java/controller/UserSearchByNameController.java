package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/searchByName")
public class UserSearchByNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String txtSearch = req.getParameter("txt");
		if (txtSearch.equals("")) {
			txtSearch = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";
		}
		List<Phim> list = new UserDAO().searchByName(txtSearch, 0);
		PrintWriter out = resp.getWriter();
		for (Phim p : list) {
			out.println("<div class=\"col-12 col-md-4 col-xl-2 col-lg-3 col-sm-6\">\r\n"
					+ "						<a href=\"" + "detail?id=" + p.getId() + "\"> <img src=\"" + p.getImageURL()
					+ "\"\r\n" + "							class=\"card-img-top\" alt=\"" + p.getTitle() + "\">\r\n"
					+ "							<p class=\"show_txt text-primary\">" + p.getTitle() + "</p></a>\r\n"
					+ "					</div>");
		}

		int a = new UserDAO().searchByNameCount(txtSearch);
		int b = a / 12;
		if (a % 12 != 0) {
			b += 1;
		}
		Map<Integer, Integer> list1 = new HashMap<Integer, Integer>();
		int index = 0;
		for (int i = 1; i <= b; i++) {
			list1.put(i, index);
			index += 12;
		}
		out.println("<div class=\"col-12\">");
		for (Integer i : list1.keySet()) {
			String test;
			if (list1.get(i) == 0) {
				test = "btn-danger";
			} else {
				test = "btn-secondary";
			}
			out.println("<span class=\"btn " + test + " menu3\"><a\r\n"
					+ "					style=\"color: rgb(240, 240, 240); padding: 0px;\" class=\"nav-link\"\r\n"
					+ "					href=\"searchByName?txt=" + txtSearch + "&x=" + list1.get(i) + "\">" + i
					+ "</a></span>");
		}
		out.println("</div>");
		if (list1.size()>0) {
			out.println("<div class=\"col-12\">");
			out.println("<hr style=\"height: 1px; border: none; background-color: rgb(240, 240, 240);\">");
			out.println("</div>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String txtSearch = req.getParameter("txt");
		int x = Integer.parseInt(req.getParameter("x"));
		List<Phim> list = new UserDAO().searchByName(txtSearch, x);
		int a = new UserDAO().searchByNameCount(txtSearch);
		int b = a / 12;
		if (a % 12 != 0) {
			b += 1;
		}
		Map<Integer, Integer> list1 = new HashMap<Integer, Integer>();
		int index = 0;
		for (int i = 1; i <= b; i++) {
			list1.put(i, index);
			index += 12;
		}

		req.setAttribute("categoryPhimLe", new UserDAO().getCategoryPhimLe());
		req.setAttribute("categoryPhimBo", new UserDAO().getCategoryPhimBo());
		req.setAttribute("categoryPhimChieuRap", new UserDAO().getCategoryPhimChieuRap());
		req.setAttribute("categoryPhimHoatHinh", new UserDAO().getCategoryPhimHoatHinh());

		req.setAttribute("phimBoCapNhat", new UserDAO().getPhimBoCapNhat());
		req.setAttribute("phimLeCapNhat", new UserDAO().getPhimLeCapNhat());
		req.setAttribute("phimChieuRapCapNhat", new UserDAO().getPhimChieuRapCapNhat());
		req.setAttribute("phimHoatHinhCapNhat", new UserDAO().getPhimHoatHinhCapNhat());

		req.setAttribute("searchByName", list);

		req.setAttribute("size", list1);

		req.setAttribute("x", x);
		req.setAttribute("txt", txtSearch);

		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}
}
