package io.tutorial.springbootstarter.endpont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.tutorial.springbootstarter.entities.User;
import io.tutorial.springbootstarter.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.POST, value="/create")
	public void createUser(@RequestBody User user){
		userService.saveUser(user);
	}
	@RequestMapping("/readAll")
	public Object getAllUser(){
		return userService.getAllUsers();
	}
	@RequestMapping("/read/{id}")
	public User getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id){
		userService.UpdateUser(user);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
}
