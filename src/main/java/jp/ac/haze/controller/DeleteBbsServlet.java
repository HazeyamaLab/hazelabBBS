package main.java.jp.ac.haze.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.jp.ac.haze.service.BbsService;
import main.java.jp.ac.haze.service.PostService;

@WebServlet("/bbs/delete")
public class DeleteBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteBbsServlet() {

		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bbsId = request.getParameter("id");
		PostService postService = new PostService();
		postService.deletePostByBbsId(Integer.parseInt(bbsId));
		BbsService bbsService = new BbsService();
		bbsService.deleteBbs(Integer.parseInt(bbsId));
		response.sendRedirect("/hazelabBBS/bbs");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
