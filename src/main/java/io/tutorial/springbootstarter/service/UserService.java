package io.tutorial.springbootstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.tutorial.springbootstarter.entities.User;
import io.tutorial.springbootstarter.entities.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public void saveUser(User entity) {
		repository.save(entity);
	}

	public void UpdateUser(User entity) {
		repository.save(entity);
	}

	public void deleteUser(String id) {
		repository.delete(id);
		
	}
	public User getUser(String id) {
		return repository.findOne(id);
	}
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}
}
