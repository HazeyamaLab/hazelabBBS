package main.java.jp.ac.haze.service;

import java.sql.Connection;

import main.java.jp.ac.haze.dao.UserDao;
import main.java.jp.ac.haze.model.User;

public class UserService {

	private Connection connection = null;

	public UserService() {

	}

	public void createUser(User user) {
		UserDao dao = new UserDao();

		this.connection = dao.createConnection();
		dao.create(user, connection);
		dao.closeConnection(connection);
		this.connection = null;
	}
}
