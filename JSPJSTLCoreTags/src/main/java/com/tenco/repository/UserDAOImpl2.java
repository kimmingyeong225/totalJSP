package com.tenco.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.models.User;

/*
 *  인터페이스 설계 생략 ...
 */
public class UserDAOImpl2 {

	private static final String URL = "jdbc:mysql://localhost:3306/demo3?serverTimezon=Asia/Seoul";
	private static final String USER = "root";
	private static final String PASSWORD = "asd123";
	
	public UserDAOImpl2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public List<User> getAUsers() {
		List<User> list = new ArrayList();
		
		String sql = " SELECT * FROM users " ;
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setEmail(rs.getString("email"));
					list.add(user);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
