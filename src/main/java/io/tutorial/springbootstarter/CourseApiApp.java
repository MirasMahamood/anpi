package io.tutorial.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"io.tutorial.springbootstarter.config","io.tutorial.springbootstarter.endpont","io.tutorial.springbootstarter.service","io.tutorial.springbootstarter.entities"})
public class CourseApiApp {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class, args);
	}

}
