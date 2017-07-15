package io.tutorial.springbootstarter.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import io.tutorial.springbootstarter.entities.User;

@EnableScan
public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findById(int id);
}