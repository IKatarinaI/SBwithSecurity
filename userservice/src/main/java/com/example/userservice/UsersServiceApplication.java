package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UsersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "USER"));
			userService.saveRole(new Role(null, "MANAGER"));
			userService.saveRole(new Role(null, "ADMIN"));

			userService.saveUser(new User(null, "johnD", "1234", "John Doe", "john.doe@gmail.com", new ArrayList<>()));
			userService.saveUser(new User(null, "janeD", "1234", "Jane Doe", "jane.doe@gmail.com", new ArrayList<>()));
			userService.saveUser(new User(null, "johanD", "1234", "Johan Doe", "johan.doe@gmail.com", new ArrayList<>()));

			userService.addRoleToUser("johnD", "USER");
		};
	}
}
