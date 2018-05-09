package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.DriverAccsessor;

public class UserDao extends DriverAccsessor{

	public User findOne(String userId,Connection connection) {
		try {
			String sql = "select * from users where user_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			
			ResultSet rSet = statement.executeQuery();
			rSet.first();
			
			User user = new User();
			user.setName(rSet.getString("user_name"));
			user.setPassword(rSet.getString("password"));
			user.setUserId(rSet.getString("user_id"));
			
			statement.close();
			rSet.close();
			
			return user;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}