package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.web.repository")
public class Pp31CrudMvcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pp31CrudMvcBootApplication.class, args);
	}

}
