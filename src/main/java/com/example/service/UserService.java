package com.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.User;

@Service
public class UserService {

	 @Autowired
	  private DataSource dataSource;
	
	//TODO Have to use JPA instead of sql statements
	public void saveUser(User user) throws SQLException {
		try (Connection connection = dataSource.getConnection()) {
		      PreparedStatement statement =  connection.prepareStatement("INSERT INTO users(userId, id, title, body) VALUES (?, ?, ?, ?)");
		      statement.setInt(1, user.getUserId());
		      statement.setInt(2, user.getId());
		      statement.setString(3, user.getTitle());
		      statement.setString(4, user.getBody());
		      statement.executeUpdate();
		}
	}

	public void UpdateUser(User user) throws SQLException {
		try (Connection connection = dataSource.getConnection()) {
		      PreparedStatement statement =  connection.prepareStatement("UPDATE users SET id=?, title=?, body=? WHERE userId=?");
		      statement.setInt(1, user.getId());
		      statement.setString(2, user.getTitle());
		      statement.setString(3, user.getBody());
		      statement.setInt(4, user.getUserId());
		      statement.executeUpdate();
		}
	}

	public void deleteUser(int userId) throws SQLException {
		try (Connection connection = dataSource.getConnection()) {
		      PreparedStatement statement =  connection.prepareStatement("DELETE FROM users WHERE userId=?");
		      statement.setInt(1, userId);
		      statement.executeUpdate();
		}
	}
	public User getUser(int userId) throws SQLException {
		User user = null;
		try (Connection connection = dataSource.getConnection()) {
		      PreparedStatement statement =  connection.prepareStatement("SELECT userId, id, title, body FROM users WHERE userId=?");
		      statement.setInt(1, userId);
		      ResultSet rs = statement.executeQuery();
		      if(rs.next()) {
		    	  user = new User();
		    	  user.setUserId(userId);
		    	  user.setId(rs.getInt("id"));
		    	  user.setTitle(rs.getString("title"));
		    	  user.setBody(rs.getString("body"));
		      }
		}
		return user;
	}
	public List<User> getAllUsers() throws SQLException {
		List<User> userList = new ArrayList<>();
		try (Connection connection = dataSource.getConnection()) {
		      PreparedStatement statement =  connection.prepareStatement("SELECT userId, id, title, body FROM users");
		      ResultSet rs = statement.executeQuery();
		      while(rs.next()) {
		    	  User user = new User();
		    	  user.setUserId(rs.getInt("userId"));
		    	  user.setId(rs.getInt("id"));
		    	  user.setTitle(rs.getString("title"));
		    	  user.setBody(rs.getString("body"));
		    	  userList.add(user);
		      }
		}
		return userList; 
	}
	public void createTable() throws SQLException {
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS USERS (userId int, id int, title varchar(255), body varchar(255))");
		}
	}
}
