package main.java.jp.ac.haze.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.jp.ac.haze.model.User;
import main.java.jp.ac.haze.service.UserService;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/user")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/home.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		User user = new User();
		user.setName(userName);
		user.setUserId(userId);
		user.setPassword(password);
		UserService userService = new UserService();
		userService.createUser(user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

}
