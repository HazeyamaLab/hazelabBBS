package main.java.jp.ac.haze.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.jp.ac.haze.model.Post;
import main.java.jp.ac.haze.utility.DriverAccsessor;

public class PostDao extends DriverAccsessor {

	public void create(Post post, Connection connection) {
		try {
			String sql = "insert into posts(user_id,bbs_id,title,body,created_at) values (?,?,?,?,?);";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, post.getContributorId());
			statement.setInt(2, post.getBbsId());
			statement.setString(3, post.getTitle());
			statement.setString(4, post.getBody());
			statement.setObject(5, post.getCreatedAt());

			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Post> findByBbsId(int bbsId, Connection connection) {
		try {
			String sql = "select * from posts where bbs_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bbsId);
			ResultSet resultSet = statement.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (resultSet.next()) {
				Post post = new Post();
				post.setPostId(resultSet.getInt("id"));
				post.setBbsId(resultSet.getInt("bbs_id"));
				post.setContributorId(resultSet.getString("user_id"));
				post.setBody(resultSet.getString("body"));
				post.setTitle(resultSet.getString("title"));
				post.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
				posts.add(post);
			}
			return posts;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteByBbsId(int bbsId, Connection connection) {
		try {
			String sql = "delete from posts where bbs_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bbsId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int postId, Connection connection) {
		try {
			String sql = "delete from posts where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, postId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Post post, Connection connection) {
		try {
			String sql = "update posts set title = ? , body = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, post.getTitle());
			statement.setString(2, post.getBody());
			statement.setInt(3, post.getPostId());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Post findOne(int postId, Connection connection) {
		try {
			String sql = "select * from posts where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, postId);
			ResultSet resultSet = statement.executeQuery();
			resultSet.first();
			Post post = new Post();
			post.setPostId(resultSet.getInt("id"));
			post.setBbsId(resultSet.getInt("bbs_id"));
			post.setContributorId(resultSet.getString("user_id"));
			post.setTitle(resultSet.getString("title"));
			post.setBody(resultSet.getString("body"));
			post.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
			statement.close();
			resultSet.close();
			return post;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
