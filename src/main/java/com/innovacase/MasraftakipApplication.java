package com.innovacase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.innovacase.models", "com.innovacase.repositories" , "com.innovacase.controllers","com.innovacase.services"})
@EnableJpaRepositories({"com.innovacase.models", "com.innovacase.repositories","com.innovacase.controllers","com.innovacase.services"})
@SpringBootApplication
public class MasraftakipApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasraftakipApplication.class, args);
	}

}
