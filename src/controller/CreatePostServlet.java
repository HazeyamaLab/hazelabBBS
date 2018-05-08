package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bbs;
import model.Post;
import model.User;
import service.BbsService;
import service.PostService;

@WebServlet("/bbs/post")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreatePostServlet() {
        super();
    }

	//BBS内の投稿を表示
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bbsId = request.getParameter("id");
		PostService postService = new PostService();
		List<Post> posts = postService.getPostByBbsId(Integer.parseInt(bbsId));
		BbsService bbsService = new BbsService();
		Bbs bbs = bbsService.getBbs(Integer.parseInt(bbsId));
		request.setAttribute("posts", posts);
		request.setAttribute("bbs", bbs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs/post/post.jsp");
		dispatcher.forward(request, response);
	}
	//BBSに投稿
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String bbsId = request.getParameter("bbsId");
		System.out.println(Integer.parseInt(bbsId));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Post post = new Post();
		post.setContributorId(user.getUserId());
		post.setTitle(title);
		post.setBody(body);
		post.setBbsId(Integer.parseInt(bbsId));
		PostService postService = new PostService();
		postService.addPost(post);
		response.sendRedirect("/hazelabBBS/bbs/post?id="+bbsId);
	}

}
