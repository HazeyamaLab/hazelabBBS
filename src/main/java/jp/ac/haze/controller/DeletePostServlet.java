package main.java.jp.ac.haze.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.jp.ac.haze.service.PostService;

/**
 * Servlet implementation class DeletePostServlet
 */
@WebServlet("/bbs/post/delete")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletePostServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String postId = request.getParameter("id");
		String bbsId = request.getParameter("bbsId");
		PostService postService = new PostService();
		postService.deletePostByPostId(Integer.parseInt(postId));
		response.sendRedirect("/hazelabBBS/bbs/post?id=" + bbsId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
