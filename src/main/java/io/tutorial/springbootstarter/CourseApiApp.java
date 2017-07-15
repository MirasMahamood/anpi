package io.tutorial.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@ComponentScan({"io.tutorial.springbootstarter.config","io.tutorial.springbootstarter.endpont","io.tutorial.springbootstarter.service","io.tutorial.springbootstarter.entities","io.tutorial.springbootstarter.repository"})
public class CourseApiApp {

	@RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class, args);
	}

}
