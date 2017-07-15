package io.tutorial.springbootstarter.endpont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.tutorial.springbootstarter.entities.User;
import io.tutorial.springbootstarter.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/table")
	public Object createTable(){
		return userService.getAllUsers();
	}
	
	@RequestMapping("/readAll")
	public Object getAllUser(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/create")
	public void createUser(@RequestBody User user){
		userService.createtable("ANPIUser", 10L, 10L, "userId", "N");
		userService.saveUser(user);
	}
	
	@RequestMapping("/read")
	public User getUser(@RequestParam(value="userId") int userId) {
		return userService.getUser(userId);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id){
		userService.UpdateUser(user);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
