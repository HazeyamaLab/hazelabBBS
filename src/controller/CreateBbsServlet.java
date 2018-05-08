package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bbs;
import service.BbsService;

@WebServlet("/bbs")
public class CreateBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateBbsServlet() {
        super();
    }
	//BBSの表示
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BbsService bbsService = new BbsService();
		List<Bbs> bbs = bbsService.getBbs();
		request.setAttribute("bbs", bbs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs/bbs.jsp");
		dispatcher.forward(request, response);
	}
	//BBSの新規作成
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bbsTitle = request.getParameter("title");
		String description = request.getParameter("description");
		Bbs bbs = new Bbs();
		bbs.setTitle(bbsTitle);
		bbs.setDescription(description);
		BbsService bbsService = new BbsService();
		bbsService.createBbs(bbs);
		doGet(request, response);
	}

}
