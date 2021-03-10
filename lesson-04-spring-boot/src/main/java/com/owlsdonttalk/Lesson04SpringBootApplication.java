package com.owlsdonttalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


// http://localhost:8080/spring-mvc-app/swagger-ui/index.html
// http://localhost:8080/spring-mvc-app/v3/api-docs/
// https://www.baeldung.com/spring-rest-openapi-documentation

//TODO - добавить форму логина

@SpringBootApplication
public class Lesson04SpringBootApplication {

	@Bean
	public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

	public static void main(String[] args) {
		SpringApplication.run(Lesson04SpringBootApplication.class, args);
	}

}
