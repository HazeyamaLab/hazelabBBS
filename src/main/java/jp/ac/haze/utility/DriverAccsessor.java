package main.java.jp.ac.haze.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverAccsessor {
	// 使用するDBの名前
	private final static String DRIVER_URL = "jdbc:mysql://db:3306/bbs?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true";

	private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	// 自分のmysqlのユーザー名
	private final static String USER_NAME = "root";
	// 自分のmysqlのパスワード
	private final static String PASSWORD = "bbs";

	public Connection createConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
			return con;
		} catch (ClassNotFoundException e) {
			System.out.println("Can't Find JDBC Driver.\n");
		} catch (SQLException e) {
			System.out.println("Connection Error.\n");
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
