package main.java.jp.ac.haze.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.jp.ac.haze.model.Bbs;
import main.java.jp.ac.haze.utility.DriverAccsessor;

public class BbsDao extends DriverAccsessor {

	public void create(Bbs bbs, Connection connection) {
		try {
			String sql = "insert into bbs(title,description,created_at,updated_at)values(?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, bbs.getTitle());
			statement.setString(2, bbs.getDescription());
			statement.setObject(3, bbs.getCreatedAt());
			statement.setObject(4, bbs.getUpdatedAt());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Bbs> findAll(Connection connection) {
		try {
			String sql = "select * from bbs";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			List<Bbs> bbsList = new ArrayList<Bbs>();
			while (resultSet.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsId(resultSet.getInt("id"));
				bbs.setTitle(resultSet.getString("title"));
				bbs.setDescription(resultSet.getString("description"));
				bbs.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
				bbs.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
				bbsList.add(bbs);
			}
			statement.close();
			resultSet.close();

			return bbsList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Bbs findOne(int bbsId, Connection connection) {
		try {
			String sql = "select * from bbs where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bbsId);

			ResultSet resultSet = statement.executeQuery();
			resultSet.first();
			Bbs bbs = new Bbs();
			bbs.setBbsId(bbsId);
			bbs.setTitle(resultSet.getString("title"));
			bbs.setDescription(resultSet.getString("description"));
			bbs.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
			bbs.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
			statement.close();
			resultSet.close();
			return bbs;
		} catch (SQLException e) {
			return null;
		}
	}

	public void update(Bbs bbs, Connection connection) {
		try {
			String sql = "update bbs set title = ? ,description = ? , updated_at = ? where id = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, bbs.getTitle());
			statement.setString(2, bbs.getDescription());
			statement.setObject(3, bbs.getUpdatedAt());
			statement.setInt(4, bbs.getBbsId());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int bbsId, Connection connection) {
		try {
			String sql = "delete from bbs where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bbsId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
