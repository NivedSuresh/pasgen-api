package org.personal.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class PasswordGenerator {

	public static void main(String[] args) {
		SpringApplication.run(PasswordGenerator.class, args);
	}

}
