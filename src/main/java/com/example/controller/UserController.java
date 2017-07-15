package com.example.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/readAll")
	public List<User> getAllUser() throws SQLException{
		return userService.getAllUsers();
	}

	@RequestMapping(method=RequestMethod.POST, value="/create")
	public User createUser(@RequestBody User user) throws SQLException {
		userService.saveUser(user);
		return user;
	}

	@RequestMapping("/read")
	public User getUser(@RequestParam(value="userId") int userId) throws SQLException {
		return userService.getUser(userId);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/update")
	public User updateUser(@RequestBody User user) throws SQLException{
		userService.UpdateUser(user);
		return user;
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/delete")
	public String deleteUser(@RequestParam(value="userId") int userId) throws SQLException {
		userService.deleteUser(userId);
		return "Deleted Successfully";
	}
	@RequestMapping("/db")
	public void db() throws SQLException {
		userService.createTable();
	}
}
