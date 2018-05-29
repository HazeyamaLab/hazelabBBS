package service;

import java.sql.Connection;

import dao.UserDao;
import model.User;

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
